package com.nour.springnlpdemo.nlpService;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class OpenNLPService {

    private final DatabaseService databaseService;

    public OpenNLPService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    /**
     * Process the given HTML text and return a list of tokens with their types and IDs
     * @param htmlText
     * @return
     * @throws Exception
     */
    public List<String> processText(String htmlText) throws Exception {
        // Convert the HTML text to plain text
        String text = convertHtmlToPlainText(htmlText);
        // Fetch the data from the database
        Map<String,TableData> databaseData = databaseService.fetchData();
        // Detect the language of the text
        String language = detectLanguage(text);
        // Get the sentence detector and tokenizer for the detected language
        SentenceDetectorME sentenceDetector = getSentenceDetector(language);
        TokenizerME tokenizer = getTokenizer(language);
        // Get the unique tokens from the text
        Set<String> uniqueTokens = getUniqueTokens(text, sentenceDetector, tokenizer);
        // Get the list of tokens with their types and IDs
        return getTokensList(databaseData, uniqueTokens);
    }

    private String convertHtmlToPlainText(String htmlText) {
        return Jsoup.parse(htmlText).text();
    }

    /**
     * Detect the language of the given text
     * @param text
     * @return
     * @throws Exception
     */
    private String detectLanguage(String text) throws Exception {
        try (InputStream languageModelIn = new FileInputStream("langdetect-183.bin")) {
            LanguageDetectorModel languageModel = new LanguageDetectorModel(languageModelIn);
            LanguageDetector languageDetector = new LanguageDetectorME(languageModel);
            Language bestLanguage = languageDetector.predictLanguage(text);
            return bestLanguage.getLang();
        }
    }

    /**
     * Get the sentence detector for the given language
     * @param language
     * @return
     * @throws Exception
     */
    private SentenceDetectorME getSentenceDetector(String language) throws Exception {
        try (InputStream sentenceModelIn = new FileInputStream(getSentenceModelFilePath(language))) {
            SentenceModel sentenceModel = new SentenceModel(sentenceModelIn);
            return new SentenceDetectorME(sentenceModel);
        }
    }

    /**
     * Get the tokenizer for the given language
     * @param language
     * @return
     * @throws Exception
     */
    private TokenizerME getTokenizer(String language) throws Exception {
        try (InputStream tokenizerModelIn = new FileInputStream(getTokenizerModelFilePath(language))) {
            TokenizerModel tokenizerModel = new TokenizerModel(tokenizerModelIn);
            return new TokenizerME(tokenizerModel);
        }
    }

    /**
     * Get the file path of the sentence model for the given language
     * @param language
     * @return
     */
    private String getSentenceModelFilePath(String language) {
        return language.equals("fra") ? "opennlp-1.0-1.9.3fr-ud-ftb-sentence-1.0-1.9.3.bin" : "opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin";
    }

    /**
     * Get the file path of the tokenizer model for the given language
     * @param language
     * @return
     */
    private String getTokenizerModelFilePath(String language) {
        return language.equals("fra") ? "opennlp-fr-ud-ftb-tokens-1.0-1.9.3.bin" : "opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin";
    }

    /**
     * Get the unique tokens from the given text
     * @param text
     * @param sentenceDetector
     * @param tokenizer
     * @return
     */
    private Set<String> getUniqueTokens(String text, SentenceDetectorME sentenceDetector, TokenizerME tokenizer) {
        // Detect sentences in the text
        String[] sentences = sentenceDetector.sentDetect(text);
        // Get the unique tokens from the sentences
        Set<String> uniqueTokens = new HashSet<>();
        // Tokenize each sentence and add the unique tokens to the set
        for (String sentence : sentences) {
            String[] tokens = tokenizer.tokenize(sentence);
            for (String token : tokens) {
                // Remove punctuation and convert to lowercase
                String cleanToken = token.replaceAll("\\p{Punct}", "").toLowerCase();
                uniqueTokens.add(cleanToken);
            }
        }
        return uniqueTokens;
    }

    /**
     * Get the list of tokens with their types and IDs
     * @param databaseData
     * @param uniqueTokens
     * @return
     */
    private List<String> getTokensList(Map<String,TableData> databaseData, Set<String> uniqueTokens) {
        // Create a list to store the tokens with their types and IDs
        List<String> tokensList = new ArrayList<>();
        // Iterate over the unique tokens and find their corresponding types and IDs
        for (String uniqueToken : uniqueTokens) {
            // Check if the token exists in the database data
            for (Map.Entry<String, TableData> entry : databaseData.entrySet()) {
                // If the token is found, add it to the list with its type and ID
                if (entry.getKey().toLowerCase().equals(uniqueToken)) {
                    TableData tableData = entry.getValue();
                    String label = tableData.getLabel();
                    String id = tableData.getId();
                    tokensList.add("Token= " + uniqueToken + ", Type: " + label + ", Value: " + entry.getKey() + ", ID: " + id);
                    break;
                }
            }
        }
        return tokensList;
    }
}
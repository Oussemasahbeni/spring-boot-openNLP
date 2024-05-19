package com.nour.springnlpdemo;

import com.nour.springnlpdemo.nlpService.OpenNLPService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringNlpDemoApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(SpringNlpDemoApplication.class, args);

        // Call OpenNLPService
        OpenNLPService openNLPService = context.getBean(OpenNLPService.class);
        List<String> tokens= openNLPService.processText("<p>ADP recrute un Ingénieur Clients </p><p><br></p><ul><li>Cherchez-vous à rejoindre une équipe dynamique " +
                "et inclusive et travailler dans une culture de collaboration ? </li><li>Êtes-vous prêt à faire évoluer votre carrière chez un " +
                "leader mondial reconnu et réputé ? </li><li>Cherchez-vous à vivre une expérience marquante ? </li><li><br></li></ul><p>Oui ?" +
                " …Continuez à lire et découvrez par vous-même !</p><p><br></p><p>En tant qu’ingénieur clients pour l’activité des opérations" +
                " techniques National Account, vous aurez pour mission la gestion d'un portefeuille/demandes clients et ce soit à travers la" +
                " gestion de la base des données et le développement des traitements/JOB de la paie, soit à travers le développement des interfaces " +
                "WEB du Système d’Information. Votre responsabilité consiste à garantir l’excellence du service et la satisfaction client.</p><p><br></p><p>Ce que " +
                "vous devez connaitre sur ADP : Nous croyons que les grandes entreprises sont bâties par des gens formidables, pour des gens" +
                " formidables.</p><p><br></p><p>ADP collabore avec plus de 740 000 entreprises à l'échelle mondiale afin d'aider leurs employés à " +
                "travailler plus intelligemment, à relever de nouveaux défis et à développer leur talent.</p><p><br></p><p>Ce que vous allez faire :" +
                " Vos Responsabilités </p><p><br></p><p>Le Bon Déroulement De La Production</p><p><br></p><ul><li>Développer les interfaces, programmes " +
                "et écrans GXP. </li><li>Planifier les lots de développement en estimant les charges et en s’engageant sur des dates de livraisons." +
                " </li><li>Garantir le bon fonctionnement de l’application GXP en coordonnant en interne les interventions techniques. </li><li>Organiser/participer" +
                " aux plans d’évolutions de l’ensemble du parc GXP en cohérence avec les objectifs planifiés. </li><li>Implémenter les paramétrages et les prestations " +
                "d’assistance. </li><li>Estimer la charge des demandes d’évolutions par des devis. </li><li>Respecter les délais d’engagement et le processus du " +
                "traitement des demandes clients. </li><li><br></li></ul><p>Collaborer Au Quotidien</p><p><br></p><ul><li>Travailler chaque jour avec des clients" +
                " internes/externes et établir de bonnes relations avec eux. </li><li>Partager tout type d’information avec vos pairs, les fonctions supports," +
                " les vis-à-vis et votre hiérarchie dans le but d’assurer la continuité et l’excellence de service. </li><li>Participer activement dans les " +
                "réunions de production journalières. </li><li><br></li></ul><p>Expériences dont vous aurez besoin :<span> </span>Qualifications " +
                "requises</p><p><br></p><ul><li>Formation académique : Vous êtes de formation Bac+3 ou plus en ingénierie d’informatique ou diplôme équivalent. " +
                "</li><li>Compétences techniques : vous possédez des bonnes connaissances en Algorithmes, en norme de développement, en JCL sous MVS, en Java /" +
                " J2EE, en JavaScript et en IDE Eclipse. </li><li>Gestion de projet : Vous connaissez les techniques de gestion de projet, vous savez " +
                "déployer les moyens et matériels nécessaires et vous maitrisez la méthode Agile Scrum afin d’atteindre les objectifs fixés. </li><li>Maitrise du" +
                " langage de développement : Vous maitrisez le langage Cobol pour l’activité TECH et le JAVA pour l’activité Gestion Administrative du Personnel." +
                " </li><li>Positif et autonome. Vous êtes optimiste et persévérant ; vous savez bien gérer votre temps et présenter vos idées de manière claire et" +
                " professionnelle que ce soit en personne, par écrit, ou par téléphone ; vous êtes capable de gérer les situations difficiles. </li><li>Apprentissage" +
                " continu: Vous apprenez toujours des nouvelles choses, vous vous développez et vous travaillez sur l’amélioration continue. </li><li>Travail en équipe:" +
                " Vous êtes apte à participer à l’atteinte des objectifs partagés, à collaborer avec les autres et à privilégier la réussite du groupe. </li><li>Espri" +
                "t d'innovation: Vous sortez des sentiers battus et transformez les problèmes en solutions, les idées en actions et les plans en résultats et vous êtes " +
                "prêt à tout type de changement. </li><li>Gestion émotionnelle : Vous êtes empathique, vous possédez une bonne résistance au stress et faite preuve " +
                "à la fois d'assurance et de pédagogie. </li><li>Compétences linguistiques : Vous avez d’excellentes compétences en communication en langues " +
                "française écrite/verbale. </li><li><br></li></ul><p>La préférence sera accordée aux candidats qui possèdent :</p><p><br></p><ul><li>L’habitude à " +
                "travailler dans un environnement structuré, basé sur la performance tout en démontrant des normes éthiques élevées. </li><li>L'agilité dans l’apprentissage" +
                " </li><li>Les compétences en communication en langue anglaise écrite et verbale. </li><li>Les connaissances des notions de paie française." +
                " </li><li><br></li></ul><p>Vous Aimerez Travailler Ici Parce Que Vous Pouvez</p><p><br></p><ul><li>Développer vos forces et laisser votre trace" +
                " </li><li>Aimer ce que vous faites </li><li>Vivre une expérience marquante </li><li>Participer dans des activités internes passionnantes" +
                " </li><li>Concilier vie privé - vie professionnelle. </li><li><br></li></ul><p>Qu'attendez-vous ? Postuler maintenant " +
                "J</p><p><br></p><p>Diversité, équité, inclusion et égalité des chances pour obtenir un emploi chez ADP :<span>" +
                " </span>ADP confirme que l'inégalité est préjudiciable à nos collaborateurs, à nos clients et aux communautés que nous servons." +
                " Notre objectif est de faire un changement durable à travers nos actions. Ensemble, nous nous unissons pour l'égalité et l'équité. " +
                "ADP s'engage à offrir des possibilités d'emploi sans distinction de race, de couleur, d'informations génétiques, de croyance, de religion," +
                " de sexe, d'orientation sexuelle, d'identité, de statut légal, d'origine nationale, d'âge ou d'état matrimonial et ne discriminera personne sur " +
                "la base d'un handicap. Nous offrons un milieu de travail inclusif où les collaborateurs excellent sur la base des qualifications, des capacités " +
                "et de performance.</p><p><br></p><p>Éthique chez ADP : ADP a une longue et fière histoire de conduite des affaires avec les normes éthiques " +
                "les plus élevées et le respect total de toutes les lois applicables. Nous attendons également de nos collaborateurs qu'ils respectent nos valeurs " +
                "et se comportent de manière à favoriser un milieu de travail honnête et respectueux. Cliquez sur https://jobs.adp.com/life-at-adp/ pour en " +
                "savoir plus sur la culture et les valeurs d'ADP.</p><p><br></p><p>Diversity, Equity, Inclusion &amp; Equal Employment Opportunity at ADP: ADP " +
                "is committed to an inclusive, diverse and equitable workplace, and is further committed to providing equal employment opportunities regardless " +
                "of any protected characteristic including: race, color, genetic information, creed, national origin, religion, sex, affectional or sexual orientation," +
                " gender identity or expression, lawful alien status, ancestry, age, marital status, protected veteran status or disability. Hiring decisions are " +
                "based upon ADP’s operating needs, and applicant merit including, but not limited to, qualifications, experience, ability, availability, cooperation," +
                " and job performance.</p><p><br></p><p>Ethics at ADP:<span > </span>ADP has a long, proud history of conducting business with " +
                "the highest ethical standards and full compliance with all applicable laws. We also expect our people to uphold our values with" +
                " the highest level of integrity and behave in a manner that fosters an honest and respectful workplace. Click https://jobs.adp.com/life-at-adp/ to " +
                "learn more about ADP’s culture and our full set of values</p>");

        // Print the tokens
        for (String token : tokens) {
            System.out.println( token);
        }
    }



}

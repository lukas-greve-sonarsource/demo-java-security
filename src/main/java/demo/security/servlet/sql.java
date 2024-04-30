package test.sql.example; 

import java.util.StringUtils;

public class EmetteurCriteriaApp {

    private void addEmetteurCriteria(String emetteurCriteria, StringBuilder query) {
        if (StringUtils.isNotEmpty(emetteurCriteria)) {
            String emetteur = emetteurCriteria.replace("%", "").replace("*", "%").toLowerCase();

            query.append(" AND (");
            query.append("LOWER(commande.data -> 'emetteur' ->>  'domaine') like '");
            query.append(emetteur).append("' ");
            query.append("OR ");
            query.append("LOWER(commande.data -> 'emetteur' ->>  'referenceAgent') like '");
            query.append(emetteur).append("' ");
            query.append("OR ");
            query.append("LOWER(commande.data -> 'emetteur' ->>  'serviceTraitant') like '");
            query.append(emetteur).append("' ");
            query.append(") ");
        }
    }

    public static void main(String[] args) {
        EmetteurCriteriaApp app = new EmetteurCriteriaApp();
        StringBuilder query = new StringBuilder();

        String emetteurCriteria = "emetteurExample"; // example criteria
        app.addEmetteurCriteria(emetteurCriteria, query);

        System.out.println("Query: " + query.toString());
    }
}

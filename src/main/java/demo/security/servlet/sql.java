private void addEmetteurCriteria(String emetteurCriteria, StringBuilder query) {

if (StringUtils.isNotEmpty(emetteurCriteria)) {

String emetteur = emetteurCriteria.replace("%", "").replace("*", "%").toLowerCase();

query.append(" AND (LOWER(commande.data -> 'emetteur' ->> 'domaine') like '").append(emetteur).append("' ");

query.append(" OR LOWER(commande.data -> 'emetteur' ->> 'referenceAgent') like '").append(emetteur).append("' ");

query.append(" OR LOWER(commande.data -> 'emetteur' ->> 'serviceTraitant') like '").append(emetteur).append("') ");

}

}

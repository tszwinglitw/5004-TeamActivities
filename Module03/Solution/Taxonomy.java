public class Taxonomy {
    private String commonName;
    private String phylum;
    private String order;
    private String family;
    private String genus;
    private String species;
    private String taxonomyClass;
    private String kingdom;

    public Taxonomy(String commonName, String phylum, String order, String family, String genus,
            String species, String taxonomyClass, String kingdom) {
        this.commonName = commonName;
        this.phylum = phylum;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.taxonomyClass = taxonomyClass;
        this.kingdom = kingdom;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getPhylum() {
        return phylum;
    }

    public String getOrder() {
        return order;
    }

    public String getFamily() {
        return family;
    }

    public String getGenus() {
        return genus;
    }

    public String getSpecies() {
        return species;
    }

    public String getTaxonomyClass() {
        return taxonomyClass;
    }

    public String getKingdom() {
        return kingdom;
    }
}

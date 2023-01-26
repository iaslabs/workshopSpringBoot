package co.com.ias.projectBird.domain.model.bird;

public class Bird {

   private final BirdCommonName name;

   private final BirdId id;

   private final BirdScientificName scientificName;

   public Bird(BirdCommonName name, BirdId id, BirdScientificName scientificName) {
      this.name = name;
      this.id = id;
      this.scientificName = scientificName;
   }

   public BirdCommonName getName() {
      return name;
   }

   public BirdId getId() {
      return id;
   }

   public BirdScientificName getScientificName() {
      return scientificName;
   }
}

import clients.petstore.PetStoreService;
import clients.petstore.Petstore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pet.Category;
import pet.Pet;

import java.io.IOException;

public class newTest {

    private static Petstore petstore;
    private static Pet myPet = new Pet();
    @BeforeAll
    public static void beforeAll(){
        petstore = new PetStoreService().getPetstore();
        myPet.setId(1);
        myPet.setName("K");
        Category category = new Category();
        category.setName("Кот");
        myPet.setCategory(category);
        myPet.setStatus("available");
    }




    @Test
    public void CreatePet() throws IOException {
        Pet retrofitPet = petstore.createPet(myPet).execute().body();
        Assertions.assertEquals(myPet, retrofitPet);

    }

    @Test
    public void GetPet200() throws IOException {

        petstore.createPet(myPet).execute();
        int code = petstore.getPetById(myPet.getId()).execute().code();
        Assertions.assertEquals(200, code);

    }

    @Test
    public void GetPet404() throws IOException {
        petstore.deletePetById(1000).execute();
        int code = petstore.getPetById(1000).execute().code();
        Assertions.assertEquals(404, code);
    }

    @Test
    public void PutPet200() throws IOException {

        Pet myUpdatePet = new Pet();
        myUpdatePet.setId(myPet.getId());
        myUpdatePet.setName(myPet.getName());

        myUpdatePet.setCategory(myPet.getCategory());
        myUpdatePet.setStatus("sold out");

        petstore.createPet(myPet).execute();
        int code = petstore.updatePet(myUpdatePet).execute().code();
        Assertions.assertEquals(200, code);
    }

    @Test
    public void PutPet404() throws IOException {
        petstore.deletePetById(1000).execute();
        Pet myUpdatePet = new Pet();
        myUpdatePet.setId(1000);
        myUpdatePet.setName(myPet.getName());
        myUpdatePet.setCategory(myPet.getCategory());
        myUpdatePet.setStatus("sold out");

        int code = petstore.updatePet(myUpdatePet).execute().code();
        Assertions.assertEquals(404, code);
    }


    @Test
    public void DelPet200() throws IOException {

        petstore.createPet(myPet).execute();
        int code = petstore.deletePetById(myPet.getId()).execute().code();
        Assertions.assertEquals(200, code);
    }

    @Test
    public void DelPet404() throws IOException {
        petstore.deletePetById(1000).execute();
        int code = petstore.deletePetById(1000).execute().code();
        Assertions.assertEquals(404, code);
    }


}
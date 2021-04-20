package clients.petstore;

import pet.Pet;
import retrofit2.Call;
import retrofit2.http.*;

public interface Petstore {
    //метод создания питомца для ротрофита

    @POST("v2/pet")
    Call<Pet> createPet(@Body Pet pet);

    @GET("/v2/pet/{id}")
    public Call<Pet> getPetById(@Path("id") int id);

    @PUT("/v2/pet")
    Call<Pet> updatePet(@Body Pet pet);

    @DELETE("/v2/pet/{id}")
    Call<Object> deletePetById(@Path("id") int id);

}

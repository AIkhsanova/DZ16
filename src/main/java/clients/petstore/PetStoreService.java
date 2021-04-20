package clients.petstore;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PetStoreService {
    private Petstore petstore;

    public Petstore getPetstore() {
        if (petstore == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://petstore.swagger.io/")
                    .addConverterFactory(JacksonConverterFactory.create()).build();
            petstore = retrofit.create(Petstore.class);
            return petstore;
        } else return petstore;
    }
}

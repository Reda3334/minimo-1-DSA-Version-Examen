package dsa.examples.mocking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstanciaRetroFit {
    private static Retrofit retrofit = null;

    public static InterfazAPIRetroFit getAPI() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(InterfazAPIRetroFit.class);
    }
}

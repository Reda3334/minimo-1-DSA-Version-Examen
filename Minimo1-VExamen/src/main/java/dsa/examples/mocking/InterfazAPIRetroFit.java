package dsa.examples.mocking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public abstract class InterfazAPIRetroFit {
    @POST("/api/usuarios")
    abstract Call<Void> addUser(@Body UsuarioTO usuarioTO);

    @GET("/api/usuarios")
    abstract Call<List<UsuarioTO>> listUsers();

    @GET("/api/usuarios/{id}")
    abstract Call<UsuarioTO> getUserById(@Path("id") int id);

    @POST("/api/puntos")
    abstract Call<Void> addPointOfInterest(@Body PuntoInteresTO poiTO);

    @POST("/api/transitos/{userId}")
    abstract Call<Void> recordTransit(@Path("userId") int userId, @Body PuntoInteresTO poiTO);

    @GET("/api/usuarios/{userId}/transitos")
    abstract Call<List<PuntoInteresTO>> getUserTransitPoints(@Path("userId") int userId);

    @GET("/api/puntos/{x}/{y}/usuarios")
    abstract Call<List<UsuarioTO>> getUsersByPoint(@Path("x") int x, @Path("y") int y);

    @GET("/api/puntos/tipo/{tipo}")
    abstract Call<List<PuntoInteresTO>> getPointsByType(@Path("tipo") ElementType tipo);
}

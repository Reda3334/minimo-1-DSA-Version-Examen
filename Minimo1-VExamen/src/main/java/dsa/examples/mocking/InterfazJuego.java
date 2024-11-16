package dsa.examples.mocking;

import java.util.List;

public interface InterfazJuego {
    void addUser(int id, String nombre, String apellidos, String correo, String fechaNacimiento);



    List<Usuario> listUsers();
    Usuario getUserById(int id);
    void addPointOfInterest(int x, int y, ElementType tipo);
     void recordTransit(int userId, int x, int y);
    List<PuntoInteres> getUserTransitPoints(int userId);
    List<Usuario> getUsersByPoint(int x, int y);
    List<PuntoInteres> getPointsByType(ElementType tipo);
    public int size();

    List<UsuarioTO> findAll();
}

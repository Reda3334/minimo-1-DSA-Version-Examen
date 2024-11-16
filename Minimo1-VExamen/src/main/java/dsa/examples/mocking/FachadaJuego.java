package dsa.examples.mocking;


import java.util.*;

import java.util.logging.Logger;

public class FachadaJuego implements InterfazJuego {
    private static final Logger logger = Logger.getLogger("FachadaJuego");
    private static FachadaJuego instance;

    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private Map<String, PuntoInteres> puntosInteres = new HashMap<>();
    private Map<Integer, List<PuntoInteres>> transitos = new HashMap<>();

    private FachadaJuego() {}

    public static synchronized FachadaJuego getInstance() {
        if (instance == null) {
            instance = new FachadaJuego();
        }
        return instance;
    }

    @Override
    public void addUser(int id, String nombre, String apellidos, String correo, String fechaNacimiento) {
        logger.info("addUser - ID: " + id + ", Nombre: " + nombre + " " + apellidos);
        Usuario usuario = new Usuario(id, nombre, apellidos, correo, fechaNacimiento);
        usuarios.put(id, usuario);
        logger.info("Usuario añadido: " + usuario);
    }

    @Override
    public List<Usuario> listUsers() {
        logger.info("listUsers");
        List<Usuario> userList = new ArrayList<>(usuarios.values());
        userList.sort(Comparator.comparing(Usuario::getApellidos).thenComparing(Usuario::getNombre));
        return userList;
    }

    @Override
    public Usuario getUserById(int id) {
        logger.info("getUserById - ID: " + id);
        return usuarios.get(id);
    }

    @Override
    public void addPointOfInterest(int x, int y, ElementType tipo) {
        logger.info("addPointOfInterest - Coordenadas: (" + x + ", " + y + "), Tipo: " + tipo);
        String key = x + "," + y;
        PuntoInteres poi = new PuntoInteres(x, y, tipo);
        puntosInteres.put(key, poi);
        logger.info("Punto de interés añadido: " + poi);
    }

    @Override
    public void recordTransit(int userId, int x, int y) {
        logger.info("recordTransit - UserID: " + userId + ", Coordenadas: (" + x + ", " + y + ")");
        Usuario usuario = usuarios.get(userId);
        String key = x + "," + y;
        PuntoInteres poi = puntosInteres.get(key);

        if (usuario == null || poi == null) {
            logger.info("Error: Usuario o Punto de interés no encontrado");
            return;
        }

        transitos.computeIfAbsent(userId, k -> new ArrayList<>()).add(poi);
        logger.info("Transito registrado: " + usuario + " -> " + poi);
    }

    @Override
    public List<PuntoInteres> getUserTransitPoints(int userId) {
        logger.info("getUserTransitPoints - UserID: " + userId);
        return transitos.getOrDefault(userId, Collections.emptyList());
    }

    @Override
    public List<Usuario> getUsersByPoint(int x, int y) {
        logger.info("getUsersByPoint - Coordenadas: (" + x + ", " + y + ")");
        String key = x + "," + y;
        PuntoInteres poi = puntosInteres.get(key);

        if (poi == null) {
            logger.info("Error: Punto de interés no encontrado");
            return Collections.emptyList();
        }

        List<Usuario> users = new ArrayList<>();
        transitos.forEach((id, points) -> {
            if (points.contains(poi)) {
                users.add(usuarios.get(id));
            }
        });

        return users;
    }

    @Override
    public List<PuntoInteres> getPointsByType(ElementType tipo) {
        logger.info("getPointsByType - Tipo: " + tipo);
        List<PuntoInteres> points = new ArrayList<>();
        puntosInteres.values().forEach(poi -> {
            if (poi.getTipo() == tipo) {
                points.add(poi);
            }
        });
        return points;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<UsuarioTO> findAll() {
        return List.of();
    }
}


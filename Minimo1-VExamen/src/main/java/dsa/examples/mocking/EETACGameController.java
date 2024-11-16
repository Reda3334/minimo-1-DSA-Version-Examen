package dsa.examples.mocking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EETACGameController {

    private final InterfazJuego service = FachadaJuego.getInstance();

    @PostMapping("/usuarios")
    public void addUser(@RequestBody UsuarioTO usuarioTO) {
        service.addUser(usuarioTO.getId(), usuarioTO.getNombre(), usuarioTO.getApellidos(),
                usuarioTO.getCorreoElectronico(), usuarioTO.getFechaNacimiento());
    }

    @GetMapping("/usuarios")
    public List<UsuarioTO> listUsers() {
        return service.listUsers().stream()
                .map(user -> new UsuarioTO(user.getId(), user.getNombre(), user.getApellidos(),
                        user.getCorreoElectronico(), user.getFechaNacimiento()))
                .toList();
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioTO getUserById(@PathVariable int id) {
        Usuario user = service.getUserById(id);
        return new UsuarioTO(user.getId(), user.getNombre(), user.getApellidos(),
                user.getCorreoElectronico(), user.getFechaNacimiento());
    }

    @PostMapping("/puntos")
    public void addPointOfInterest(@RequestBody PuntoInteresTO poiTO) {
        service.addPointOfInterest(poiTO.getCoordenadaX(), poiTO.getCoordenadaY(), poiTO.getTipo());
    }

    @PostMapping("/transitos/{userId}")
    public void recordTransit(@PathVariable int userId, @RequestBody PuntoInteresTO poiTO) {
        service.recordTransit(userId, poiTO.getCoordenadaX(), poiTO.getCoordenadaY());
    }

    @GetMapping("/usuarios/{userId}/transitos")
    public List<PuntoInteresTO> getUserTransitPoints(@PathVariable int userId) {
        return service.getUserTransitPoints(userId).stream()
                .map(poi -> new PuntoInteresTO(poi.getCoordenadaX(), poi.getCoordenadaY(), poi.getTipo()))
                .toList();
    }

    @GetMapping("/puntos/{x}/{y}/usuarios")
    public List<UsuarioTO> getUsersByPoint(@PathVariable int x, @PathVariable int y) {
        return service.getUsersByPoint(x, y).stream()
                .map(user -> new UsuarioTO(user.getId(), user.getNombre(), user.getApellidos(),
                        user.getCorreoElectronico(), user.getFechaNacimiento()))
                .toList();
    }

    @GetMapping("/puntos/tipo/{tipo}")
    public List<PuntoInteresTO> getPointsByType(@PathVariable ElementType tipo) {
        return service.getPointsByType(tipo).stream()
                .map(poi -> new PuntoInteresTO(poi.getCoordenadaX(), poi.getCoordenadaY(), poi.getTipo()))
                .toList();
    }
}


package spring.boot.desafio.gps.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.desafio.gps.model.poi;
import spring.boot.desafio.gps.model.poiDTO;
import spring.boot.desafio.gps.repository.poiRepository;

import java.util.List;


@RestController
public class poiController {

    private final poiRepository repository;

    public poiController(poiRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/pontos-de-interesse")
    public ResponseEntity<Void> pontosInteresseCriar(@RequestBody poiDTO body) {
        repository.save(new poi(body.nome(), body.x(), body.y()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar/pontos-de-interesse")
    public ResponseEntity<List<poi>> pontosInteressesListar() {
        List<poi> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/pontos-proximos")
    public ResponseEntity<List<poi>> listarPontosProximos(
            @RequestParam("x") Long x,
            @RequestParam("y") Long y,
            @RequestParam("dmax") Long dmax) {

        Long xMin = x - dmax;
        Long xMax = x + dmax;
        Long yMin = y - dmax;
        Long yMax = y + dmax;

        List<poi> pontosFiltrados = repository.findPontosProximos(xMin, xMax, yMin, yMax)
                .stream()
                .filter(p -> distanciaPontos(x, y, p.getX(), p.getY()) <= dmax)
                .toList();

        return ResponseEntity.ok(pontosFiltrados);
    }

    public double distanciaPontos(long x1, long y1, long x2, long y2) {
        return Math.hypot(x2 - x1, y2 - y1);
    }
}

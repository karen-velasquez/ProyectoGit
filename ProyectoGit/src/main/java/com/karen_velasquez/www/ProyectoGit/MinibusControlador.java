package com.karen_velasquez.www.ProyectoGit;

import java.util.List;

import javax.el.MethodNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MinibusControlador {

  private final MinibusRepositorio repository;

  MinibusControlador(MinibusRepositorio repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/minibuses")
  List<Minibus> all() {
    return repository.findAll();
  }

  @PostMapping("/minibuses")
  Minibus newMinibus(@RequestBody Minibus newMinibus) {
    return repository.save(newMinibus);
  }

  // Single item

  @GetMapping("/minibuses/{id}")
  Minibus one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new MinibusNotFoundException(id));
    //me salia error al devolver el Minibus Not Found Exception tuve que camiarlo
  }
  
  @PutMapping("/minibuses/{id}")
  Minibus replaceMinibus(@RequestBody Minibus newMinibus, @PathVariable Long id) {

    return repository.findById(id)
      .map(minibus -> {
        minibus.setNumero(newMinibus.getNumero());
        minibus.setP_partida(newMinibus.getP_partida());
        return repository.save(minibus);
      })
      .orElseGet(() -> {
        newMinibus.setId(id);
        return repository.save(newMinibus);
      });
  }

  @DeleteMapping("/minibuses/{id}")
  void deleteMinibus(@PathVariable Long id) {
    repository.deleteById(id);
  }
}


package engtelecom.std.projetoAutomocao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

import engtelecom.std.projetoAutomocao.resources.Ambientes;
import engtelecom.std.projetoAutomocao.exceptions.AmbienteNaoEncontradoException;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {
  private final List<Ambientes> comodos = new ArrayList<>();
  private final AtomicLong contador = new AtomicLong();

  @GetMapping
  public List<Ambientes> obterTodosAmbientes() {
    return this.comodos;
  }

  @GetMapping("/{id}")
  public Ambientes obterAmbiente(@PathVariable long id) {
    for (Ambientes comodo : this.comodos) {
      if (comodo.getId() == id) {
        comodo.getDispositivos();
        return comodo;
      }
    }
    throw new AmbienteNaoEncontradoException(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Ambientes adicionaAmbiente(@RequestBody Ambientes comodo) {
    Ambientes ambiente = new Ambientes(contador.incrementAndGet(), comodo.getNome());
    this.comodos.add(ambiente);
    return ambiente;
  }

  @PostMapping("/{id}/dispositivos")
  @ResponseStatus(HttpStatus.CREATED)
  public Ambientes addDispositivo(@PathVariable long id, @RequestParam(value = "id", defaultValue = "0") long idDisp) {
    for (Ambientes a : this.comodos) {
      if (a.getId() == id) {
        a.adicionaDispositivo(idDisp);
        return a;
      }
    }
    throw new AmbienteNaoEncontradoException(id);
  }

  @PutMapping("/{id}")
  public Ambientes atualizarAmbiente(@PathVariable long id, @RequestParam(value = "nome") String nome) {

    for (Ambientes a : this.comodos) {
      if (a.getId() == id) {
        a.setNome(nome);
        return a;
      }
    }
    throw new AmbienteNaoEncontradoException(id);
  }

  @DeleteMapping("/{id}")
  public void excluirAmbiente(@PathVariable long id) {
    if (!this.comodos.removeIf(comodo -> comodo.getId() == id)) {
      throw new AmbienteNaoEncontradoException(id);
    }
  }

  @DeleteMapping("/{id}/dispositivos") 
  public void excluirDispositivo(@PathVariable long id,
      @RequestParam(value = "id", defaultValue = "0") long idDisp) {
    for (Ambientes a : this.comodos) {
      if (a.getId() == id) {
        a.excluiDispositivoAmbiente(idDisp);
      }
    }
  }

  @ControllerAdvice
  class AmbienteNaoEncontrado {
    @ResponseBody
    @ExceptionHandler(AmbienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ambienteNaoEncontrado(AmbienteNaoEncontradoException amb) {
      return amb.getMessage();
    }
  }
}

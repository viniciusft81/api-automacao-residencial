package engtelecom.std.projetoAutomocao.controller;

import engtelecom.std.projetoAutomocao.exceptions.CenarioNaoEncontradoException;
import engtelecom.std.projetoAutomocao.resources.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cenarios")
public class CenarioController {

  private final List<Cenarios> cenarios = new ArrayList<>();

  @GetMapping
  public List<Cenarios> obterTodosCenarios() {
    return this.cenarios;
  }

  @GetMapping("/{nomeCenario}")
  public Cenarios obterCenario(@PathVariable String nomeCenario) {
    for (Cenarios cenario : this.cenarios) {
      if (cenario.getNome().equals(nomeCenario)) {
        return cenario;
      }
    }
    throw new CenarioNaoEncontradoException(nomeCenario);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cenarios adicionaCenario(@RequestBody Cenarios cen) {
    Cenarios cenario = new Cenarios(cen.getNome(), cen.getInicio(), cen.getFim());
    this.cenarios.add(cenario);
    return cenario;
  }

  @PostMapping("/{nomeCenario}/dispositivos")
  @ResponseStatus(HttpStatus.CREATED)
  public Cenarios addDispositivo(@PathVariable String nomeCenario,
      @RequestParam(value = "id", defaultValue = "0") long idDisp) {
    for (Cenarios cen : this.cenarios) {
      if (cen.getNome().equals(nomeCenario)) {
        cen.addDispositivoCenario(idDisp);
        return cen;
      }
    }
    throw new CenarioNaoEncontradoException(nomeCenario);
  }

  @PutMapping("/{nomeCenario}")
  public Cenarios atualizarCenario(@PathVariable String nomeCenario, @RequestParam(value = "nome") String nome,
      @RequestParam(value = "inicio") String inicio, @RequestParam(value = "fim") String fim) {

    for (Cenarios cen : this.cenarios) {
      if (cen.getNome().equals(nomeCenario)) {
        cen.setNome(nome);
        cen.setInicio(inicio);
        cen.setFim(fim);
        return cen;
      }
    }
    throw new CenarioNaoEncontradoException(nomeCenario);
  }

  @DeleteMapping("/{nomeCenario}")
  public void deletarCenario(@PathVariable String nomeCenario) {
    if (!this.cenarios.removeIf(p -> p.getNome().equals(nomeCenario))) {
      throw new CenarioNaoEncontradoException(nomeCenario);
    }
  }

  @DeleteMapping("/{nomeCenario}/dispositivos")
  public void deletarDispositivoCenario(@PathVariable String nomeCenario,
      @RequestParam(value = "id", defaultValue = "0") long id) {
    for (Cenarios cen : this.cenarios) {
      if (cen.getNome().equals(nomeCenario)) {
        cen.excluiDispositivoCenario(id);
      }
    }
  }

  @ControllerAdvice
  class CenarioNaoEncontrado {
    @ResponseBody
    @ExceptionHandler(CenarioNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cenarioNaoEncontrada(CenarioNaoEncontradoException p) {
      return p.getMessage();
    }
  }
}

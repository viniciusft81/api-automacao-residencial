package engtelecom.std.projetoAutomocao.controller;

import engtelecom.std.projetoAutomocao.exceptions.DispositivoNaoEncontradoException;
import engtelecom.std.projetoAutomocao.resources.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

  MemoryDb dispositivos = new MemoryDb();

  @GetMapping 
  public ArrayList<Dispositivos> obterTodosDispositivos() {
    return MemoryDb.db;
  }

  @GetMapping("/{id}")
  public Dispositivos obterDispositivoPeloId(@PathVariable long id) {
    return dispositivos.buscarDispositivoPeloId(id);
  }

  @GetMapping("/lampadas") 
  public ArrayList<Lampada> obterTodasLampadas() {
    ArrayList<Lampada> lamps = new ArrayList<Lampada>();

    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof Lampada) {
        lamps.add((Lampada) d);
      }
    }
    return lamps;
  } 

  @GetMapping("/lampadas/{id}") 
  public Lampada obterLampadaPeloId(@PathVariable long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof Lampada && d.getId() == id) {
        return (Lampada)d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  @PutMapping("/lampadas/{id}") 
  public Lampada interagirDispositivoLampada(@RequestBody Lampada disp, @PathVariable long id) {
    return MemoryDb.consultarLampada(disp, id);
  }

  @GetMapping("/cortinas") 
  public ArrayList<Cortinas> obterTodasCortinas() {
    ArrayList<Cortinas> cortinas = new ArrayList<Cortinas>();

    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof Cortinas) {
        cortinas.add((Cortinas) d);
      }
    }
    return cortinas;
  } 

  @GetMapping("/cortinas/{id}") 
  public Cortinas obterCortinaPeloId(@PathVariable long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof Cortinas && d.getId() == id) {
        return (Cortinas)d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  @PutMapping("/cortinas/{id}") 
  public Cortinas interagirDispositivoCortina(@RequestBody Cortinas disp, @PathVariable int id) {
    return MemoryDb.consultarCortina(disp, id);
  }

  @GetMapping("/tv") 
  public ArrayList<Tv> obterTodasTvs() {
    ArrayList<Tv> tvs = new ArrayList<Tv>();

    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof Tv) {
        tvs.add((Tv) d);
      }
    }
    return tvs;
  } 

  @GetMapping("/tv/{id}") 
  public Tv obterTvPeloId(@PathVariable long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof Tv && d.getId() == id) {
        return (Tv)d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  @PutMapping("/tv/{id}") 
  public Tv interagirDispositivoTelevisao(@RequestBody Tv disp, @PathVariable int id) {
    return MemoryDb.consultarTv(disp, id);
  }

  @GetMapping("/sistemaSom") 
  public ArrayList<SistemaSom> obterTodosSom() {
    ArrayList<SistemaSom> sons = new ArrayList<SistemaSom>();

    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof SistemaSom) {
        sons.add((SistemaSom) d);
      }
    }
    return sons;
  } 

  @GetMapping("/sistemaSom/{id}") 
  public SistemaSom obterSomPeloId(@PathVariable long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof SistemaSom && d.getId() == id) {
        return (SistemaSom)d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  @PutMapping("/sistemaSom/{id}") 
  public SistemaSom atualizarDispositivoSom(@RequestBody SistemaSom disp, @PathVariable int id) {
    return MemoryDb.consultarSistemaSom(disp, id);
  }

  @GetMapping("/arCondicionado") 
  public ArrayList<ArCondicionado> obterTodosArCond() {
    ArrayList<ArCondicionado> arConds = new ArrayList<ArCondicionado>();

    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof ArCondicionado) {
        arConds.add((ArCondicionado) d);
      }
    }
    return arConds;
  } 

  @GetMapping("/arCondicionado/{id}") 
  public ArCondicionado obterArCondPeloId(@PathVariable long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof ArCondicionado && d.getId() == id) {
        return (ArCondicionado)d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  @PutMapping("/arCondicionado/{id}") 
  public ArCondicionado interagirDispositivoArcondicionado(@RequestBody ArCondicionado disp, @PathVariable long id) {
    return MemoryDb.consultarArCond(disp, id);
  }

  @GetMapping("/portoes") 
  public ArrayList<PortaoEletronico> obterTodosPortoes() {
    ArrayList<PortaoEletronico> portoes = new ArrayList<PortaoEletronico>();

    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof PortaoEletronico) {
        portoes.add((PortaoEletronico) d);
      }
    }
    return portoes;
  } 

  @GetMapping("/portoes/{id}") 
  public PortaoEletronico obterPortaoPeloId(@PathVariable long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d instanceof PortaoEletronico && d.getId() == id) {
        return (PortaoEletronico)d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  @PutMapping("/portoes/{id}")
  public PortaoEletronico atualizarDispositivoPortao(@RequestBody PortaoEletronico disp, @PathVariable int id) {
    return MemoryDb.consultarPortao(disp, id);
  }

  @ControllerAdvice
  class DispositivoNaoEncontrado {
    @ResponseBody
    @ExceptionHandler(DispositivoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dispositivoNaoEncontrado(DispositivoNaoEncontradoException p) {
      return p.getMessage();
    }
  }
}

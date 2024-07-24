package engtelecom.std.projetoAutomocao.resources;

import engtelecom.std.projetoAutomocao.exceptions.DispositivoNaoEncontradoException;

import java.util.ArrayList;

public class MemoryDb {
  public static ArrayList<Dispositivos> db;

  public MemoryDb() {
    db = new ArrayList<>();
    addDispositivos();
  }

  public void addDispositivos() {
    Lampada lampada = new Lampada(1, "lampada1");
    Cortinas cortina = new Cortinas(2, "cortina1");
    Tv tv = new Tv(3, "tv grande");
    SistemaSom som = new SistemaSom(4, "som");
    PortaoEletronico portao = new PortaoEletronico(5, "portao grande");
    ArCondicionado arCond = new ArCondicionado(6, "arcondicionado principal");
    Lampada outraLamp = new Lampada(7, "lampada2");
    Cortinas outraCortina = new Cortinas(8, "cortina2");
    Tv outraTv = new Tv(9, "tv pequena");
    SistemaSom outroSom = new SistemaSom(10, "som bom");
    PortaoEletronico outroPortao = new PortaoEletronico(11, "portao pequeno");
    ArCondicionado outroArCond = new ArCondicionado(12, "arcondicionado pequeno");

    // adicionando os dispositivos
    db.add(lampada);
    db.add(cortina);
    db.add(tv);
    db.add(som);
    db.add(portao);
    db.add(arCond);
    db.add(outraLamp);
    db.add(outraCortina);
    db.add(outraTv);
    db.add(outroSom);
    db.add(outroPortao);
    db.add(outroArCond);
  }

  public Dispositivos buscarDispositivoPeloId(long id) {
    for (Dispositivos disp : db) {
      if (disp.getId() == id) {
        return disp;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static Lampada consultarLampada(Lampada disp, long id) {
    for (Dispositivos d : db) {
      if (d.getId() == id) {
        d.setId(id);
        d.setNome(disp.getNome());
        ((Lampada) d).setIntensidade(((Lampada) disp).getIntensidade());
        ((Lampada) d).setCor(((Lampada) disp).getCor());
        ((Lampada) d).setLigado(((Lampada) disp).isLigar());
        return (Lampada) d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static Cortinas consultarCortina(Cortinas disp, long id) {
    for (Dispositivos d : db) {
      if (d.getId() == id) {
        d.setId(id);
        d.setNome(disp.getNome());
        ((Cortinas) d).setAberto(((Cortinas) disp).getAberto());
        return (Cortinas) d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static Tv consultarTv(Tv disp, long id) {
    for (Dispositivos d : db) {
      if (d.getId() == id) {
        d.setId(id);
        d.setNome(disp.getNome());
        ((Tv) d).setVolume(((Tv) disp).getVolume());
        ((Tv) d).setLigado(((Tv) disp).isLigar());
        return (Tv) d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static SistemaSom consultarSistemaSom(SistemaSom disp, long id) {
    for (Dispositivos d : db) {
      if (d.getId() == id) {
        d.setId(id);
        d.setNome(disp.getNome());
        ((SistemaSom) d).setVolume(((SistemaSom) disp).getVolume());
        ((SistemaSom) d).setLigado(((SistemaSom) disp).isLigar());
        return (SistemaSom) d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static ArCondicionado consultarArCond(ArCondicionado disp, long id) {
    for (Dispositivos d : db) {
      if (d.getId() == id) {
        d.setId(id);
        d.setNome(disp.getNome());
        ((ArCondicionado) d).setTemperatura(((ArCondicionado) disp).getTemperatura());
        ((ArCondicionado) d).setLigado(((ArCondicionado) disp).isLigar());
        return (ArCondicionado) d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static PortaoEletronico consultarPortao(PortaoEletronico disp, long id) {
    for (Dispositivos d : db) {
      if (d.getId() == id) {
        d.setNome(disp.getNome());
        d.setId(id);
        ((PortaoEletronico) d).setAberto(((PortaoEletronico) disp).getAberto());
        return (PortaoEletronico) d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public static void setDispositivo(Dispositivos disp, int id) {
    db.set(id, disp);
  }
}

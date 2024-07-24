package engtelecom.std.projetoAutomocao.resources;

import java.util.ArrayList;

import engtelecom.std.projetoAutomocao.exceptions.DispositivoNaoEncontradoException;

public class Ambientes {
  private long id;
  private String nome;
  private ArrayList<Dispositivos> dispositivos;

  Ambientes() {
  }

  public Ambientes(long id, String nome) {
    this.id = id;
    this.nome = nome;
    this.dispositivos = new ArrayList<>();
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDisp(Dispositivos equipamento) {
    this.dispositivos.add(equipamento);
  }

  public ArrayList<Dispositivos> getDispositivos() {
    return dispositivos;
  }

  public Dispositivos buscaDispositivoPeloId(long id) {
    for (Dispositivos disp : dispositivos) {
      if (disp.getId() == id) {
        return disp;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public void adicionaDispositivo(long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d.getId() == id) {
        System.out.println(d);
        this.dispositivos.add(d);
      }
    }
  }

  public void excluiDispositivoAmbiente(long id) {
    dispositivos.removeIf(d -> d.getId() == id);
  }
}

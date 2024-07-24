package engtelecom.std.projetoAutomocao.resources;

import java.util.ArrayList;

import engtelecom.std.projetoAutomocao.exceptions.DispositivoNaoEncontradoException;

public class Cenarios {
  private String nome;
  private String inicio;
  private String fim;
  private ArrayList<Dispositivos> dispositivosCenario;

  public Cenarios(String nome, String init, String end) {
    this.nome = nome;
    this.inicio = init;
    this.fim = end;
    this.dispositivosCenario = new ArrayList<>();
  }

  public Cenarios() {
  }

  public Dispositivos buscaDispositivoPeloId(long id) {
    for (Dispositivos d : dispositivosCenario) {
      if (d.getId() == id) {
        return d;
      }
    }
    throw new DispositivoNaoEncontradoException(id);
  }

  public void addDispositivoCenario(long id) {
    for (Dispositivos d : MemoryDb.db) {
      if (d.getId() == id) {
        this.dispositivosCenario.add(d);
      }
    }
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setFim(String fim) {
    this.fim = fim;
  }

  public String getFim() {
    return fim;
  }

  public void setInicio(String inicio) {
    this.inicio = inicio;
  }

  public String getInicio() {
    return inicio;
  }

  public void excluiDispositivoCenario(long id) {
    dispositivosCenario.removeIf(d -> d.getId() == id);
  }

  public ArrayList<Dispositivos> getDispositivos() {
    return dispositivosCenario;
  }
}

package engtelecom.std.projetoAutomocao.resources;

public abstract class Dispositivos {
  private long id;
  private String nome;

  public Dispositivos(long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Dispositivos() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
}

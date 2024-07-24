package engtelecom.std.projetoAutomocao.resources;

public class Cortinas extends Dispositivos {
  private boolean aberto = false;

  public Cortinas() {
  }

  public Cortinas(long id, String nome) {
    super(id, nome);
  }

  public void setAberto(boolean abrir) {
    this.aberto = abrir;
  }

  public boolean getAberto() {
    return aberto;
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public long getId() {
    return super.getId();
  }
}

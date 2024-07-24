package engtelecom.std.projetoAutomocao.resources;

public class SistemaSom extends Dispositivos {
  private int volume=10;
  private boolean ligado = false;

  public SistemaSom(long id, String nome) {
    super(id, nome);
  }

  public SistemaSom() {
  }

  public void setLigado(boolean ligar) {
    this.ligado = ligar;
  }

  public boolean isLigar() {
    return ligado;
  }

  public void setVolume(int volume) {
    if (volume < 100) {
      this.volume = volume;
    }
  }

  public int getVolume() {
    return volume;
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

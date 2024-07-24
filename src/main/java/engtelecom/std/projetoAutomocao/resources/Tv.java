package engtelecom.std.projetoAutomocao.resources;

public class Tv extends Dispositivos {
  private int canal=4;
  private int volume=5;
  private boolean ligado = false;

  public Tv(long id, String nome) {
    super(id, nome);
  }

  public Tv() {
  }

  public void setVolume(int volume) {
    if (volume < 100) {
      this.volume = volume;
    }
  }

  public void setLigado(boolean ligar) {
    this.ligado = ligar;
  }

  public boolean isLigar() {
    return ligado;
  }

  public int getVolume() {
    return volume;
  }

  public void setCanal(int canal) {
    if (canal < 100) {
      this.canal = canal;
    }
  }

  public int getCanal() {
    return canal;
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

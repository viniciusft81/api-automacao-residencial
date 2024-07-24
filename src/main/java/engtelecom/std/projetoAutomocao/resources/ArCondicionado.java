package engtelecom.std.projetoAutomocao.resources;

public class ArCondicionado extends Dispositivos{
  private int temperatura=20;
  private boolean ligado = false;

  public ArCondicionado(long id, String nome) {
    super(id, nome);
  }

  public ArCondicionado() {
  }

  public int getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(int temperatura) {
    this.temperatura = temperatura;
  }
  public void setLigado(boolean ligar) {
    this.ligado = ligar;
  }

  public boolean isLigar() {
    return ligado;
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

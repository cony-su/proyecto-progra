package project;

class Factura //ESTA CLASE REPRESENTA UNA FACTURA INDIVIDUAL
{
  private String idFactura;
  private double monto;
  private String fechaEmision; 
  private boolean pagado;

  //CONSTRUCTOR
  public Factura(String idFactura, double monto, String fechaEmision, boolean pagado) {
    this.idFactura = idFactura;
    this.monto = monto;
    this.fechaEmision = fechaEmision;
    this.pagado = pagado;
  }

  //SETTERS Y GETTERS
  public String getIdFactura() {
    return idFactura;
  }

  public void setIdFactura(String idFactura) {
    this.idFactura = idFactura;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public String getFechaEmision() {
    return fechaEmision;
  }

  public void setFechaEmision(String fechaEmision) {
    this.fechaEmision = fechaEmision;
  }

  public boolean getPagado() {
    return pagado;
  }

  public void setPagado(boolean pagado) {
    this.pagado = pagado;
  }
  
  public boolean pagarFactura(){
	if(pagado) return false;
	this.pagado = true;
	return true;
  }
}
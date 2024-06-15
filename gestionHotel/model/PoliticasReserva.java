package model;

public class PoliticasReserva {
	private int cantDiasTemprano;
	private int cantDiasTarde;
	private float dtoTemprano;
	private float recragoTarde;
	
	public int getCantDiasTemprano() {
		return cantDiasTemprano;
	}
	public void setCantDiasTemprano(int cantDiasTemprano) {
		this.cantDiasTemprano = cantDiasTemprano;
	}
	public int getCantDiasTarde() {
		return cantDiasTarde;
	}
	public void setCantDiasTarde(int cantDiasTarde) {
		this.cantDiasTarde = cantDiasTarde;
	}
	public float getDtoTemprano() {
		return dtoTemprano;
	}
	public void setDtoTemprano(float dtoTemprano) {
		this.dtoTemprano = dtoTemprano;
	}
	public float getRecragoTarde() {
		return recragoTarde;
	}
	public void setRecragoTarde(float recragoTarde) {
		this.recragoTarde = recragoTarde;
	}
	
	public PoliticasReserva(int cantDiasTemprano, int cantDiasTarde, float dtoTemprano, float recragoTarde) {
		super();
		this.cantDiasTemprano = cantDiasTemprano;
		this.cantDiasTarde = cantDiasTarde;
		this.dtoTemprano = dtoTemprano;
		this.recragoTarde = recragoTarde;
	}
	
}

package plugin.mousehunt.setup;

public enum EPowerType {
	PHYSICAL("Physical");
	
	private String name;
	
	private EPowerType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

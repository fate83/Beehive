package de.stealmycode.beehive.config;

import java.util.List;
import java.util.Map;

public class GraphicsConfig extends Config {
	
	public static final String TAG_IMAGES = "Images";
	public static final String TAG_TEXTUR = "Textures";
	
	@SuppressWarnings("unchecked")
    public Map<Integer, Object> getImages() {
		Map<String, Object> data = (Map<String, Object>)getData();
		return (Map<Integer, Object>)data.get(TAG_IMAGES);
	}
	
    @SuppressWarnings("unchecked")
    public List<Object> getImage(int i) {
		return (List<Object>) getImages().get(i);
	}
	
	@SuppressWarnings("unchecked")
    public Map<Integer, String> getTextures() {
		Map<String, Object> data = (Map<String, Object>)getData();
		return (Map<Integer, String>)data.get(TAG_TEXTUR);
	}
	
	public String getTexture(int i) {
		return getTextures().get(i);
	}
}

package models;

import java.io.File;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

import play.modules.morphia.Blob;
import play.modules.morphia.Model;
import utils.S;

@Entity
public class Image extends Model{
	
	public String url;	
	public String headline;
	public String description;
	public Boolean isMain;
	
	@Reference(ignoreMissing=true)
	public Project project;
	
}

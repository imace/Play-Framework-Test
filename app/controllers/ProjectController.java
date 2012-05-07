package controllers;

import java.util.List;

import models.Project;
import play.Logger;
import play.data.validation.Valid;
import play.mvc.Controller;

public class ProjectController extends Controller {

	/**
	 * Display the new project form
	 */
    public static void newProject() {
    	 render("Project/newProject.html");
    }
    
    /**
     * Create new project from form
     * @param project
     */
    public static void createProject(@Valid Project project){
    	// Handle errors
        if(validation.hasErrors()) {
            render("Project/newProject.html",project);
        }
        
        //Hack because checkbox binding issue
        if (params.get("project.nonProfit") == null){
        	project.nonProfit = false;
        }else{
        	project.nonProfit = true;
        }
        	
    	//Create the project
    	project.save();
    	
    	flash.success("Project successfully created");
    	
    	//Go to the project list page
    	projectList();
    }
    
    /**
     * Shows a list of all the created projects in the system
     */
    public static void projectList(){
    	List<Project> projects = Project.findAll();
    	
    	render("Project/projectList.html", projects);
    }
    
    
    /**
     * Displays the project profile page
     * @param idProject
     */
    public static void showProject(Long idProject){
    	Logger.debug("Showing project: ", idProject);
    	Project project = Project.findById(idProject);
    	   	
    	render("Project/project.html", project);
    }

}

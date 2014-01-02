package me.gizio.toodledo4j;

public interface Toodledo4J {

	boolean initialize(String email, String password, String appId, String appToken);

	boolean addTodo();

	boolean getTodo();

	boolean editTodo();

	boolean deleteTodo();

//	void addFolder();
//
//	void getFolder();
//
//	void editFolder();
//
//	void deleteFolder();
//
//	void addContext();
//
//	void getContext();
//
//	void editContext();
//
//	void deleteContext();
//
//	void addGoal();
//
//	void getGoal();
//
//	void editGoal();
//
//	void deleteGoal();
//
//	void addLocation();
//
//	void getLocation();
//
//	void editLocation();
//
//	void deleteLocation();
//
//	void addNote();
//
//	void getNote();
//
//	void editNote();
//
//	void deleteNote();

}

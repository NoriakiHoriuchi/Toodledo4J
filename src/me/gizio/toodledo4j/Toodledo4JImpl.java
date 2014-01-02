package me.gizio.toodledo4j;

import me.gizio.toodledo4j.auth.AuthInfo;

public class Toodledo4JImpl implements Toodledo4J {

	private static Toodledo4JImpl instance = new Toodledo4JImpl();

	private Toodledo4JImpl() {
	}

	public static Toodledo4JImpl getInstance() {
		return instance;
	}

	@Override
	public boolean initialize(String email, String password, String appId,
			String appToken) {
		AuthInfo auth = AuthInfo.getInstance();
		return auth.initialize(email, password, appId, appToken);
	}

	@Override
	public boolean addTodo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTodo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editTodo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTodo() {
		// TODO Auto-generated method stub
		return false;
	}

	// @Override
	// public void addFolder() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getFolder() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void editFolder() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void deleteFolder() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void addContext() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getContext() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void editContext() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void deleteContext() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void addGoal() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getGoal() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void editGoal() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void deleteGoal() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void addLocation() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getLocation() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void editLocation() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void deleteLocation() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void addNote() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getNote() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void editNote() {
	// // XXX Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void deleteNote() {
	// // XXX Auto-generated method stub
	//
	// }

}

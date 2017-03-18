package hostel_world.model.list;

import hostel_world.model.RoomPlan;

import java.util.List;

public class RoomList {
	private List roomList;

	public List getRoomList() {
		return roomList;
	}

	public void setRoomList(List roomList) {
		this.roomList = roomList;
	}

	public RoomPlan getRoomList(int index){
		return (RoomPlan)roomList.get(index);
	}
}

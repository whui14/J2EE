package hostel_world.dao;

import hostel_world.model.Room;

public interface RoomDao {
	/**
	 * 根据房间名得到房间的信息
	 * @param title
	 * @return
	 */
	public Room getRoom(String title);
	/**
	 * 添加新的房间入数据库
	 * @param Room
	 */
	public void addNewRoom(Room Room);
	/**
	 * 判断某房间是否已经在数据库中了
	 * @param title
	 * @return
	 */
	public boolean searchRoom(String title);
}

package hostel_world.model.list;

import hostel_world.model.Hostel;

import java.io.Serializable;
import java.util.List;
import java.util.zip.ZipFile;

public class HostelList implements Serializable{
	private List HostelList;

	public List getHostelList() {
		return HostelList;
	}

	public void setHostelList(List HostelList) {
		this.HostelList = HostelList;
	}
	
	public Hostel getHostelList(int index){
		return (Hostel)HostelList.get(index);
	}

}

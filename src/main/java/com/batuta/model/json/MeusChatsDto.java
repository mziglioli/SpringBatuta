package com.batuta.model.json;

import java.io.Serializable;
import java.util.List;

public class MeusChatsDto implements Serializable {
    private static final long serialVersionUID = 1L;
	private List<MeusChats> meusChats;

	public MeusChatsDto() {
		// TODO Auto-generated constructor stub
	}

	public MeusChatsDto(List<MeusChats> meusChats) {
		this.meusChats = meusChats;
	}

	public List<MeusChats> getMeusChats() {
		return meusChats;
	}

	public void setMeusChats(List<MeusChats> meusChats) {
		this.meusChats = meusChats;
	}

	@Override
	public String toString() {
		return "MeusChatsDto [meusChats=" + meusChats + "]";
	}
	
}

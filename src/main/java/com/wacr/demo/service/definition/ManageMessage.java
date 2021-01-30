package com.wacr.demo.service.definition;

import java.util.ArrayList;

import com.wacr.demo.model.GetMessage;
import com.wacr.demo.model.PostMessage;

public interface ManageMessage {

	public GetMessage[] getMessage();

	public ArrayList<PostMessage> modifyMessage();
}

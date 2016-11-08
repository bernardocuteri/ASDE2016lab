package it.unical.login.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

public class ChatController {
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public DeferredResult<List<String>> getMessages(@RequestParam int messageIndex) {

	  final DeferredResult<List<String>> deferredResult = new DeferredResult<List<String>>(null, Collections.emptyList());
	  this.chatRequests.put(deferredResult, messageIndex);

	  deferredResult.onCompletion(new Runnable() {
	    @Override
	    public void run() {
	      chatRequests.remove(deferredResult);
	    }
	  });

	  List<String> messages = this.chatRepository.getMessages(messageIndex);
	  if (!messages.isEmpty()) {
	    deferredResult.setResult(messages);
	  }

	  return deferredResult;
	}
}

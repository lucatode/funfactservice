package com.lucatode.funfactservice.domain.task;

import java.util.TimerTask;

public class EmptyTask extends TimerTask {
  @Override
  public void run() {
    System.out.println("task run");
  }
}

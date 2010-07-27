/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.impl.interceptor;

import org.activiti.impl.cfg.ProcessEngineConfiguration;
import org.activiti.impl.msg.MessageSessionFactory;
import org.activiti.impl.persistence.PersistenceSessionFactory;
import org.activiti.impl.timer.TimerSessionFactory;
import org.activiti.impl.tx.TransactionContextFactory;


/**
 * @author Tom Baeyens
 */
public class CommandContextFactory {

  protected ProcessEngineConfiguration processEngineConfiguration;
  
  // TODO remove (they are in process engine configuration)
  
  private TransactionContextFactory transactionContextFactory;

  public CommandContext createCommandContext(Command<?> cmd) {
    return new CommandContext(cmd, processEngineConfiguration, transactionContextFactory);
  }
  
  // getters and setters //////////////////////////////////////////////////////
  
  public ProcessEngineConfiguration getProcessEngineConfiguration() {
    return processEngineConfiguration;
  }
  public void setProcessEngineConfiguration(ProcessEngineConfiguration processEngineConfiguration) {
    this.processEngineConfiguration = processEngineConfiguration;
  }
  public void setTransactionContextFactory(TransactionContextFactory transactionContextFactory) {
    this.transactionContextFactory = transactionContextFactory;
  }
  public TransactionContextFactory getTransactionContextFactory() {
    return transactionContextFactory;
  }
}
/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.spin.xml.dom.format.spi;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.camunda.spin.impl.logging.SpinLogger;
import org.camunda.spin.impl.xml.dom.DomXmlLogger;
import org.camunda.spin.impl.xml.dom.format.spi.JaxBContextProvider;

/**
 * @author Thorben Lindhauer
 *
 */
public class EmptyContextProvider implements JaxBContextProvider {

  private static final DomXmlLogger LOG = SpinLogger.XML_DOM_LOGGER;

  @Override
  public JAXBContext getContext(Class<?>... types) {
    try {
      return JAXBContext.newInstance();
    } catch (JAXBException e) {
      throw LOG.unableToCreateContext(e);
    }
  }

}

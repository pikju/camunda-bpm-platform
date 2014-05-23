/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.spin.xml.dom;

import org.camunda.spin.impl.xml.dom.SpinXmlDomAttribute;
import org.camunda.spin.impl.xml.dom.SpinXmlDomAttributeException;
import org.camunda.spin.impl.xml.dom.SpinXmlDomElement;
import org.camunda.spin.xml.XmlTestConstants;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.spin.Spin.XML;

/**
 * @author Sebastian Menski
 */
public class XmlDomAttributeTest {

  private SpinXmlDomAttribute attribute;

  @Before
  public void getAttribute() {
    attribute = XML(XmlTestConstants.EXAMPLE_XML).attr("order");
  }

  @Test
  public void getValue() {
    assertThat(attribute.value()).isEqualTo("order1");
  }

  @Test
  public void getName() {
    assertThat(attribute.name()).isEqualTo("order");
  }

  @Test
  public void getNamespace() {
    assertThat(attribute.namespace()).isNull();
  }

  @Test
  public void hasNamespace() {
    assertThat(attribute.hasNamespace(null)).isTrue();
  }

  @Test
  public void setValue() {
    assertThat(attribute.value("order2").value()).isEqualTo("order2");
  }

  @Test(expected = SpinXmlDomAttributeException.class)
  public void setNullValue() {
    attribute.value(null);
  }

  @Test
  public void remove() {
    String namespace = attribute.namespace();
    String name = attribute.name();

    SpinXmlDomElement element = attribute.remove();
    assertThat(element.hasAttrNs(namespace, name)).isFalse();
  }

}

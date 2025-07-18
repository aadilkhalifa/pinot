/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.pinot.spi.utils.JsonUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;


public class ExecutionStatsTest {

  private JsonNode _mockBrokerResponse;

  private ExecutionStats _executionStatsUnderTest;

  @BeforeMethod
  public void setUp()
      throws Exception {
    String json =
        "{\"numServersQueried\":10, \"numServersResponded\":10, \"numDocsScanned\":10, "
            + "\"numEntriesScannedInFilter\":10, \"numEntriesScannedPostFilter\":10, \"numSegmentsQueried\":10, "
            + "\"numSegmentsProcessed\":10, \"numSegmentsMatched\":10, \"numConsumingSegmentsQueried\":10, "
            + "\"minConsumingFreshnessTimeMs\":10, \"totalDocs\":10, \"numGroupsLimitReached\":true, "
            + "\"timeUsedMs\":10, \"groupsTrimmed\": true}";
    _mockBrokerResponse = JsonUtils.stringToJsonNode(json);
    _executionStatsUnderTest = new ExecutionStats(_mockBrokerResponse);
  }

  @Test
  public void testGetNumServersQueried() {
    // Run the test
    final int result = _executionStatsUnderTest.getNumServersQueried();

    // Verify the results
    assertEquals(10, result);
  }

  @Test
  public void testGetNumServersResponded() {
    // Run the test
    final int result = _executionStatsUnderTest.getNumServersResponded();

    // Verify the results
    assertEquals(10, result);
  }

  @Test
  public void testGetNumDocsScanned() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumDocsScanned();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetNumEntriesScannedInFilter() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumEntriesScannedInFilter();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetNumEntriesScannedPostFilter() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumEntriesScannedPostFilter();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetNumSegmentsQueried() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumSegmentsQueried();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetNumSegmentsProcessed() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumSegmentsProcessed();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetNumSegmentsMatched() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumSegmentsMatched();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetNumConsumingSegmentsQueried() {
    // Run the test
    final long result = _executionStatsUnderTest.getNumConsumingSegmentsQueried();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetMinConsumingFreshnessTimeMs() {
    // Run the test
    final long result = _executionStatsUnderTest.getMinConsumingFreshnessTimeMs();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testGetTotalDocs() {
    // Run the test
    final long result = _executionStatsUnderTest.getTotalDocs();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testIsNumGroupsLimitReached() {
    // Run the test
    final boolean result = _executionStatsUnderTest.isNumGroupsLimitReached();

    // Verify the results
    assertTrue(result);
  }

  @Test
  public void testIsGroupsTrimmed() {
    // Run the test
    final boolean result = _executionStatsUnderTest.isGroupsTrimmed();

    // Verify the results
    assertTrue(result);
  }

  @Test
  public void testGetTimeUsedMs() {
    // Run the test
    final long result = _executionStatsUnderTest.getTimeUsedMs();

    // Verify the results
    assertEquals(10L, result);
  }

  @Test
  public void testToString() {
    // Run the test
    final String result = _executionStatsUnderTest.toString();

    // Verify the results
    assertNotEquals("", result);
  }

  @Test
  public void testFromJson() {
    // Run the test
    final ExecutionStats result = ExecutionStats.fromJson(_mockBrokerResponse);

    // Verify the results
    assertNotNull(result);
    assertEquals(10, result.getNumServersQueried());
  }
}

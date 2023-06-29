package org.xrpl.xrpl4j.model.transactions.metadata;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.junit.jupiter.api.Test;
import org.xrpl.xrpl4j.model.AbstractJsonTest;

class MetaLedgerEntryTypeTest extends AbstractJsonTest {

  @Test
  void testConstants() {
    assertThat(MetaLedgerEntryType.ACCOUNT_ROOT.value()).isEqualTo("AccountRoot");
    assertThat(MetaLedgerEntryType.AMENDMENTS.value()).isEqualTo("Amendments");
    assertThat(MetaLedgerEntryType.CHECK.value()).isEqualTo("Check");
    assertThat(MetaLedgerEntryType.DEPOSIT_PRE_AUTH.value()).isEqualTo("DepositPreauth");
    assertThat(MetaLedgerEntryType.DIRECTORY_NODE.value()).isEqualTo("DirectoryNode");
    assertThat(MetaLedgerEntryType.ESCROW.value()).isEqualTo("Escrow");
    assertThat(MetaLedgerEntryType.FEE_SETTINGS.value()).isEqualTo("FeeSettings");
    assertThat(MetaLedgerEntryType.LEDGER_HASHES.value()).isEqualTo("LedgerHashes");
    assertThat(MetaLedgerEntryType.NEGATIVE_UNL.value()).isEqualTo("NegativeUNL");
    assertThat(MetaLedgerEntryType.NFTOKEN_OFFER.value()).isEqualTo("NFTokenOffer");
    assertThat(MetaLedgerEntryType.OFFER.value()).isEqualTo("Offer");
    assertThat(MetaLedgerEntryType.PAY_CHANNEL.value()).isEqualTo("PayChannel");
    assertThat(MetaLedgerEntryType.RIPPLE_STATE.value()).isEqualTo("RippleState");
    assertThat(MetaLedgerEntryType.SIGNER_LIST.value()).isEqualTo("SignerList");
    assertThat(MetaLedgerEntryType.TICKET.value()).isEqualTo("Ticket");
  }

  @Test
  void testJson() throws JsonProcessingException {
    String json = "{\"type\":\"AccountRoot\"}";
    MetaLedgerEntryTypeWrapper wrapper = objectMapper.readValue(json, MetaLedgerEntryTypeWrapper.class);
    assertThat(wrapper.type()).isEqualTo(MetaLedgerEntryType.ACCOUNT_ROOT);
  }

  @Value.Immutable
  @JsonSerialize(as = ImmutableMetaLedgerEntryTypeWrapper.class)
  @JsonDeserialize(as = ImmutableMetaLedgerEntryTypeWrapper.class)
  interface MetaLedgerEntryTypeWrapper {

    MetaLedgerEntryType type();

  }
}
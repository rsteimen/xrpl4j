package com.ripple.xrpl4j.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableMemo.class)
@JsonDeserialize(as = ImmutableMemo.class)
public interface Memo {

  static ImmutableMemo.Builder builder() {
    return ImmutableMemo.builder();
  }

  @JsonProperty("MemoData")
  Optional<String> memoData();

  @JsonProperty("MemoFormat")
  Optional<String> memoFormat();

  @JsonProperty("MemoType")
  Optional<String> memoType();

  @Value.Check
  default void oneOrMoreFieldsPopulated() {
    int numFields = 0;
    if (memoData().isPresent()) {
      numFields++;
    }

    if (memoFormat().isPresent()) {
      numFields++;
    }

    if (memoType().isPresent()) {
      numFields++;
    }

    Preconditions.checkArgument(numFields != 0, "Memo must have one or more fields populated.");
  }
}

# CDAP Wrangler Enhancement: Byte Size and Time Duration Support

## ✨ Overview

This enhancement introduces native support for parsing **byte size** (e.g., `10MB`, `2.5GB`) and **time duration** (e.g., `30s`, `2min`) values into the CDAP Wrangler parser system.

It also includes a new directive `aggregate-stats` that demonstrates how these new data types can be used for aggregations.

---

## 🚀 Features Added

- ✅ Lexer and grammar changes for `BYTE_SIZE` and `TIME_DURATION`
- ✅ New token classes:
  - `ByteSize.java`
  - `TimeDuration.java`
- ✅ Parser and visitor integration via `visitValue`
- ✅ JUnit tests verifying parsing and value correctness
- ✅ New directive: `aggregate-stats`

---

## 📘 New Directive: `aggregate-stats`

### Usage

```wrangler
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec

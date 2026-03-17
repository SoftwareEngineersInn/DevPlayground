# Movena MVP — BA Gap Analysis Resolutions

> **Document type:** Business Analysis — Gap Resolution Record
> **Project:** Movena (Mobility Marketplace — Costa Rica, GAM Region)
> **Status:** Living document — updated as gaps are resolved
> **Last updated:** 2026-03-13

---

## Gap #2 — Payment & Escrow

### Decision
- **Payment provider:** Stripe
- **Currency:** CRC (Costa Rican Colón) — all USD references in the spec ($100 cap, reward examples) must be converted to CRC equivalents
- **Escrow model:** Upfront — funds are held in escrow at the moment the SME publishes an order
- **Escrow release conditions (either triggers release):**
  1. SME explicitly confirms delivery via the platform
  2. 24-hour auto-release after the courier marks the order as "Delivered" — if SME takes no action

---

## Gap #3 — Matching Algorithm

### Decision
- **Two anchor points per order:** Origin (pickup location) and Destination (delivery location)
- **Independent deviation radius per anchor:** Each anchor has its own configurable tolerance radius
- **Compatibility rule:** An order is shown to a courier only if:
  - The courier's route passes within the **origin radius** (pickup) AND within the **destination radius** (delivery), or vice versa
- **Hard filter:** Orders outside a courier's tolerance are never displayed — no partial matches shown

---

## Gap #4 — Platform Type

### Decision
- **Couriers:** Flutter mobile app only (iOS + Android)
- **SMEs:** React web dashboard only
- There is no cross-platform overlap — each user type has a dedicated interface suited to their context

---

## Gap #5 — Delivery Confirmation

### Decision
- **Courier action:** Taps "Delivered" button in the Flutter app
- **Optional proof:** Courier may upload a photo at delivery as proof (not mandatory)
- **Confirmation window triggered:** Upon courier marking delivered, a 24-hour SME confirmation window begins
- **Release triggers (either):**
  1. SME confirms delivery within the 24h window → escrow released immediately
  2. No SME action within 24h → escrow auto-released to courier

---

## Gap #6 — ID Verification & Trust System

### 6.1 Courier Verification

| Attribute | Detail |
|-----------|--------|
| Required documents | Cédula de Identidad + Hoja de Criminalidad (issued by any Tribunales de Justicia office in CR) |
| Review method | Manual — Movena team |
| Review SLA | 48 hours from submission |
| Courier transport modes | Any — personal vehicle, motorcycle, or public transportation |
| Rejection & resubmission | Up to **3 resubmission attempts** allowed |

**Account state during review:**
- Courier can browse available orders but cannot accept them until approved

**Hoja de Criminalidad renewal:**
- Must be renewed **annually**
- Grace period: **3 months** before expiry triggers restriction
- Renewal becomes **optional** if courier holds the Trusted badge (IC ≥ 80% after ≥ 10 orders — see Section 6.3)

---

### 6.2 SME Verification — Progressive Trust Model

| Stage | Condition | Capabilities |
|-------|-----------|--------------|
| Self-registration | Email + phone + self-declared business name | Browse platform, create draft orders |
| Verified | Cédula de Identidad uploaded + reviewed by Movena team (48h SLA) | Publish live orders (up to 10) |
| Trusted | Verified + IC ≥ 80% after ≥ 10 orders | Publish unlimited orders |

**Notes:**
- Cédula Jurídica is **NOT required** — Movena explicitly targets informal entrepreneurs without formal business registration
- SMEs can create **draft orders** while pending verification (not visible to couriers until verified)
- Rejection & resubmission: Up to **3 resubmission attempts** allowed
- SME order cap: **10 published orders max** until Trusted badge is earned

---

### 6.3 Índice de Confiabilidad (IC) — Trust Index

**Applies to:** Both Couriers and SMEs
**Visibility:** Public — both parties can view each other's IC score

**Formula:**
```
IC = (Orders Delivered / (Orders Delivered + Orders Cancelled)) × 100
```
> Simple ratio, no weighting applied (MVP decision)

**Minimum sample size:** IC is only calculated and displayed after **10 completed orders**
- Before 10 orders: **"Welcome Aboard" badge** displayed

**Cancellation rules (symmetric for both parties):**
- IC is affected **only** if a party cancels **after mutual acceptance** (both parties have confirmed each other)
- Cancellations before mutual acceptance: no IC impact
- **Disputed cancellations:** Reviewed by Movena team — team decides if justification is sufficient to waive IC impact

**IC Threshold System:**

| IC Range | Status | Behaviour |
|----------|--------|-----------|
| ≥ 80% | Trusted | Trusted badge unlocked — full benefits active |
| 70–79% | Retained | No action — badge and benefits maintained |
| 60–69% | Warning | Warning message displayed: *"Trust is key for Movena and all collaborators"* |
| < 60% | Suspended | Benefits lost — badge suspended, recoverable once IC climbs back |

**Recovery:** Always possible — no permanent loss. Benefits are restored once IC recovers above the required threshold.

---

### 6.4 Trusted Badge — Benefits & Unlocks

**Unlock condition:** ≥ 10 completed orders AND IC ≥ 80%
**Cannot unlock:** ≥ 10 orders but IC < 80% — "Welcome Aboard" badge remains, Trusted badge locked

| User Type | Benefit on Trusted Badge Unlock |
|-----------|----------------------------------|
| Courier | Hoja de Criminalidad annual renewal becomes optional |
| SME | Order publishing cap lifted (from 10 → unlimited) |

---

## Gap #8 (Partial) — Notifications Infrastructure

### Decision
- **Push notification provider:** Firebase Cloud Messaging (FCM)
- **Coverage:** Flutter mobile app (courier push) + React web dashboard (SME web push)
- **Status:** Channel confirmed — full notification event spec still pending

---

## Gap #1 — User Stories / Functional Requirements

### Decision
- **Status:** Resolved — full user story set produced
- **Output:** `_bmad-output/planning-artifacts/user-stories.md`
- **Scope:** 34 user stories across 10 epics covering all 3 actors (Courier, SME, Movena Ops)
- **Epics:** Courier Onboarding, Courier Mobility Events, SME Onboarding, Order Management, Order Discovery & Application, Delivery Execution, Payment & Escrow, Trust & IC System, Notifications (FCM), Admin/Operations Panel

---

## Gaps Remaining

### 🚨 Critical
*(None — all critical gaps resolved)*

### ⚠️ Important
7. Non-functional requirements (security, performance, privacy)
8. Notifications — full event specification (what triggers what, to whom, with what message)
9. In-app communication between courier and SME
10. Admin / operations panel definition
11. Dispute resolution process
12. SME onboarding / vetting flow detail

### 📝 Minor / Intentional?
13. Rating system — only IC stats tracked (intentional?)
14. Real-time order tracking — not yet addressed

### 📝 Spec Cleanup
- Convert all USD amounts in the spec to CRC equivalents

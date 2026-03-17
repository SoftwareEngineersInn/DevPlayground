# Movena MVP — User Stories & Non-Functional Requirements

> **Document type:** Business Analysis — Functional Requirements / User Stories
> **Project:** Movena (Mobility Marketplace — Costa Rica, GAM Region)
> **Status:** Living document — v1.1 (all MVP gaps resolved)
> **Last updated:** 2026-03-17
> **Author:** Mary (BA Agent) — reviewed with Lucian

---

## Actors

| Actor | Platform |
|-------|----------|
| **Courier** | Flutter mobile app (iOS + Android) |
| **SME** | React web dashboard |
| **Movena Ops** | Admin panel (managed internally by Lucian) |

---

## Non-Functional Requirements

### NFR-1 — Scale & Performance
- **Target launch:** 100–200 couriers, 30–50 SMEs (GAM seed launch)
- **Infrastructure headroom:** Stack must support up to 2,000 couriers / 500 SMEs on minimal infrastructure without architectural changes
- **Geo-matching:** Order compatibility queries must use indexed geometry columns (PostGIS) from day one — no full-table scans
- **Response time:** No hard SLA defined for MVP; standard web/mobile responsiveness expected

### NFR-2 — Authentication & Security
- **Auth provider:** Firebase Auth (unified with FCM — same SDK)
- **Session management:** JWT with refresh tokens, managed by Firebase Auth
- **Transport:** HTTPS enforced on all endpoints — no plain HTTP
- **Payment security:** PCI compliance delegated to Stripe — no raw card data stored or transmitted through Movena servers
- **Rate limiting:** API rate limiting applied to all public endpoints to prevent abuse
- **Input validation:** All user-submitted data validated and sanitised server-side
- **Document storage:** Identity documents (cédula, hoja de criminalidad) stored in private, access-controlled cloud storage — not publicly accessible

### NFR-3 — Data Privacy (Ley 8968 — Costa Rica)
- **Explicit consent:** Users must explicitly consent to data collection at registration
- **Data minimisation:** Only data strictly necessary for platform operation collected and stored
- **Right to deletion:** Users can request account and personal data deletion
- **Contact privacy:** The platform never exposes user phone numbers or personal contact details to counterparties — in-app chat is the coordination channel
- **Document access:** Identity documents accessible only to Movena Ops reviewers — not to other users

---

## Epic Index

| Epic | Title |
|------|-------|
| E1 | Courier Onboarding & Identity Verification |
| E2 | Courier Mobility Events |
| E3 | SME Onboarding & Identity Verification |
| E4 | Order Management (SME) |
| E5 | Order Discovery & Application (Courier) |
| E6 | Delivery Execution |
| E7 | Payment & Escrow |
| E8 | Trust & IC System |
| E9 | Notifications (FCM) |
| E10 | Admin / Operations Panel |
| E11 | In-App Communication |

---

## EPIC 1 — Courier Onboarding & Identity Verification

### US-1.1 — Courier Registration
> As a Courier, I want to create an account with my name, email, phone, and profile photo so that I can access the Movena platform.

**Acceptance Criteria:**
- Required fields: full name, email, phone, password, profile photo
- Must accept platform Terms & Conditions before account creation
- Account created in "Pending Verification" state
- Courier can log in and browse orders but cannot apply

---

### US-1.2 — Submit Identity Documents
> As a Courier, I want to upload my Cédula de Identidad and Hoja de Criminalidad so that Movena can verify my identity and activate my account.

**Acceptance Criteria:**
- Both documents required (image upload: JPG/PNG/PDF)
- Submission enters "Under Review" state (48h SLA)
- Up to 3 resubmission attempts allowed after rejection
- Courier sees current submission status on their profile

---

### US-1.3 — Browse Orders While Pending Verification
> As a Courier in "Pending Verification" state, I want to browse compatible delivery orders so that I can plan ahead while my documents are being reviewed.

**Acceptance Criteria:**
- Compatible orders visible in browse/list view
- "Apply" button disabled with tooltip: *"Complete verification to accept orders"*
- No IC score shown yet (insufficient orders)

---

### US-1.4 — Receive Verification Decision Notification
> As a Courier, I want to be notified of my verification result so that I know whether I can start accepting orders.

**Acceptance Criteria:**
- FCM push notification sent on approval or rejection
- On approval: account state → "Active"; apply button unlocked
- On rejection: notification includes reason; resubmission option shown if attempts remain
- After 3 failed attempts: account locked with message to contact support

---

## EPIC 2 — Courier Mobility Events

### US-2.1 — Declare a Mobility Event
> As a Courier, I want to declare a mobility event with my origin, destination, departure time window, deviation radii, and max load capacity so that the system can match me with compatible orders.

**Acceptance Criteria:**
- Required fields: origin (map pin or address), destination (map pin or address), departure time window (start + end time), origin deviation radius (km), destination deviation radius (km), max load capacity (kg)
- Event saved and immediately active for matching
- Courier can have multiple active events

---

### US-2.2 — Manage Mobility Events
> As a Courier, I want to edit or deactivate my mobility events so that my available routes stay accurate.

**Acceptance Criteria:**
- Courier can edit any field of a saved event
- Courier can deactivate (not delete) an event — deactivated events excluded from matching
- If an event has a pending application, warn courier before deactivation

---

## EPIC 3 — SME Onboarding & Identity Verification

### US-3.1 — SME Self-Registration
> As an SME, I want to register with my email, phone, and business name so that I can access the Movena web dashboard.

**Acceptance Criteria:**
- Required fields: business name (self-declared), owner name, email, phone, password
- No Cédula Jurídica required
- Account created in "Self-Registered" state
- SME can browse the platform and create draft orders but cannot publish

---

### US-3.2 — Submit Cédula for SME Verification
> As an SME, I want to upload my Cédula de Identidad so that Movena can verify my identity and allow me to publish orders.

**Acceptance Criteria:**
- Image upload (JPG/PNG/PDF)
- Submission enters "Under Review" (48h SLA)
- Up to 3 resubmission attempts allowed
- On approval: state → "Verified"; can publish up to 10 live orders
- On rejection: reason shown; resubmission option available

---

### US-3.3 — Create Draft Orders While Unverified
> As a self-registered SME, I want to create and save draft orders so that I can prepare my orders while verification is pending.

**Acceptance Criteria:**
- SME can create and save orders in "Draft" state
- Draft orders not visible to couriers
- "Publish" button disabled with tooltip: *"Complete verification to publish orders"*

---

### US-3.4 — SME Onboarding Wizard
> As a newly registered SME, I want to be guided through a step-by-step onboarding wizard on my first login so that I understand how to use the platform before publishing my first order.

**Acceptance Criteria:**
- Wizard triggered automatically on first login only
- Steps:
  1. Welcome & platform overview (what Movena is)
  2. How orders work (publish → couriers apply → select → delivery)
  3. How courier matching works (route-based, deviation radii)
  4. How payment & escrow works (upfront capture, 24h confirmation window)
  5. How to publish your first order (guided walkthrough of the publish form)
- Each step is skippable individually
- Entire wizard can be dismissed and restarted from the dashboard help section
- Wizard completion tracked — not shown again on subsequent logins

---

## EPIC 4 — Order Management (SME)

### US-4.1 — Publish a Delivery Order
> As a Verified SME, I want to publish a delivery order with pickup location, delivery location, order value, weight, and courier reward so that couriers can apply.

**Acceptance Criteria:**
- Required fields: pickup address, delivery address, declared order value (max CRC equivalent of $100 USD), package weight (kg), courier reward (CRC)
- Movena fee (15%) calculated and displayed before confirmation — SME pays: reward + 15%
- Escrow (reward + 15% fee) captured via Stripe at publish time
- Order becomes visible to compatible couriers (matched by route radii per Gap #3)
- Verified SMEs: max 10 published orders enforced
- Trusted SMEs: no publishing cap

---

### US-4.2 — View Order Status & Applicants
> As an SME, I want to see who has applied for my order and their IC scores so that I can make an informed courier selection.

**Acceptance Criteria:**
- Order detail page shows: status (Draft / Open / Assigned / In Transit / Delivered / Cancelled), list of applicants
- Each applicant shows: name, profile photo, IC score or "Welcome Aboard" badge, total deliveries, total cancellations
- Applicant list visible only to the order's SME

---

### US-4.3 — Select a Courier
> As an SME, I want to select one courier from my applicants so that the delivery can proceed.

**Acceptance Criteria:**
- SME taps "Select" — triggers Soft Commitment (Phase 1)
- Selected courier receives FCM push notification
- Other applicants notified their application was not selected
- Order status → "Assigned"
- Courier expected to appear for pickup same day

---

### US-4.4 — Cancel an Order
> As an SME, I want to cancel an order before pickup so that I can handle situations where delivery is no longer needed.

**Acceptance Criteria:**
- Cancellation allowed before courier physically picks up the order (before Hard Commitment)
- Cancellation before courier selection: escrow fully refunded
- Cancellation after selection but before pickup: escrow refunded; IC impact applied per Gap #6 rules (only if after mutual acceptance)
- Order status → "Cancelled"; assigned courier notified via FCM

---

### US-4.5 — Confirm Delivery
> As an SME, I want to confirm that my order was delivered so that the courier's payment is released immediately.

**Acceptance Criteria:**
- Confirm button available once courier marks order as "Delivered"
- 24h window countdown displayed to SME from the moment courier marks delivered
- On SME confirmation: escrow released to courier immediately via Stripe
- If no SME action within 24h and no open dispute: escrow auto-released (system-triggered)
- Optional: SME can view delivery photo proof if courier uploaded one

---

## EPIC 5 — Order Discovery & Application (Courier)

### US-5.1 — View Compatible Orders
> As an active Courier, I want to see delivery orders compatible with my declared mobility events so that I only see relevant opportunities.

**Acceptance Criteria:**
- Hard filter applied: only orders where pickup falls within origin radius AND delivery falls within destination radius are shown (Gap #3)
- Orders outside tolerance never displayed
- Each order card shows: pickup area, delivery area, reward (CRC), package weight, SME name, SME IC score or badge
- Exact addresses and SME identity revealed only after mutual acceptance

---

### US-5.2 — Apply for an Order
> As an active Courier, I want to apply for a compatible order so that the SME can consider me for the delivery.

**Acceptance Criteria:**
- Courier taps "Apply" — added to SME's applicant list; SME notified via FCM
- Courier sees application status: "Pending Selection"
- Apply action only available to accounts in "Active" (verified) state

---

### US-5.3 — Withdraw an Application
> As a Courier, I want to withdraw my application before the SME selects me so that I can back out of opportunities I no longer want.

**Acceptance Criteria:**
- Withdrawal allowed before SME confirms selection
- No IC impact (pre-mutual-acceptance cancellation)
- SME's applicant list updates to remove the courier

---

### US-5.4 — View Active Order Status
> As a Courier, I want to see the current status of my accepted orders so that I always know what action is expected of me next.

**Acceptance Criteria:**
- Active order screen shows current status: Assigned / Picked Up / Delivered
- Status-specific call-to-action shown per state:
  - Assigned → "Confirm Pickup"
  - Picked Up → "Mark as Delivered"
  - Delivered → "Awaiting SME Confirmation" (with countdown)
- No live GPS tracking — status-based updates only
- In-app chat with SME accessible from the active order screen for pickup coordination

---

## EPIC 6 — Delivery Execution

### US-6.1 — Confirm Order Pickup
> As an assigned Courier, I want to confirm that I've physically picked up the order so that Hard Commitment (Phase 2) is activated.

**Acceptance Criteria:**
- "Confirm Pickup" button in Flutter app
- On confirmation: order state → "In Transit"; Movena guarantee fund becomes active
- SME notified via FCM

---

### US-6.2 — Mark Order as Delivered
> As a Courier, I want to mark an order as delivered so that the 24h SME confirmation window begins and I can receive payment.

**Acceptance Criteria:**
- "Mark as Delivered" button in Flutter app
- Order status → "Delivered"
- 24h auto-release timer starts (paused if a dispute is raised before expiry)
- SME receives FCM push notification to confirm delivery

---

### US-6.3 — Upload Delivery Photo Proof
> As a Courier, I want to optionally upload a photo at delivery so that I have evidence in case of a dispute.

**Acceptance Criteria:**
- Photo upload available on the "Mark as Delivered" screen (optional)
- Photo stored and accessible to SME on order detail page
- Photo accessible to Movena ops for dispute review

---

### US-6.4 — Cancel After Mutual Acceptance
> As a Courier, I want to cancel a delivery I've accepted — with full awareness of IC impact — so that I can handle unexpected situations.

**Acceptance Criteria:**
- Cancellation available after mutual acceptance but before Hard Commitment (pickup)
- Warning shown before cancellation: *"Cancelling after acceptance will affect your IC score"*
- IC impact recorded if cancellation proceeds (unless disputed and waived by Movena)
- Dispute option available on cancellation confirmation screen
- SME notified; order returns to "Open" state for new courier selection

---

## EPIC 7 — Payment & Escrow

### US-7.1 — Escrow Captured at Order Publication
> As the system, escrow (reward + 15% Movena fee) is automatically captured via Stripe when an SME publishes an order so that funds are secured before any courier commits.

**Acceptance Criteria:**
- Stripe payment intent created and captured at publish time
- If payment fails: order not published; SME shown payment error
- Escrow held until order is resolved (delivered, cancelled, or claimed)

---

### US-7.2 — Escrow Auto-Release After 24h
> As the system, I want to auto-release escrow to the courier 24 hours after delivery is marked if the SME takes no action so that couriers are always paid even if SMEs are unresponsive.

**Acceptance Criteria:**
- Timer starts when courier marks "Delivered"
- At T+24h with no SME action and no open dispute: Stripe transfer executed to courier
- If a dispute is raised before T+24h: auto-release timer is paused — escrow frozen until ops resolves the dispute
- Both parties notified of auto-release via FCM

---

### US-7.3 — View Payment History
> As a Courier or SME, I want to view my payment history so that I can track my earnings and transactions.

**Acceptance Criteria:**
- Courier: list of completed deliveries with reward amount (CRC) and date
- SME: list of orders with cost breakdown (reward + 15% Movena fee) per order

---

### US-7.4 — Guarantee Fund Claim
> As an SME, I want to file a guarantee fund claim if a courier fails to deliver after pickup so that I am compensated for my lost order value.

**Acceptance Criteria:**
- Claim option available only after Hard Commitment (courier confirmed pickup) AND a reasonable time has passed without a "Delivered" status
- SME provides: description of incident, any supporting evidence (messages, photos)
- Claim enters Movena ops review queue; escrow frozen for the order's duration
- On approval: SME compensated up to the declared order value (capped at CRC equivalent of $100 USD) from the guarantee fund
- Both parties notified of claim outcome via FCM
- Courier account flagged; repeated offences may result in permanent ban (per platform terms)

---

### US-7.5 — Escrow Freeze on Open Dispute
> As the system, when a dispute is raised on an order with pending escrow, I want to freeze the escrow so that funds are not auto-released until Movena ops resolves the dispute.

**Acceptance Criteria:**
- Any open dispute (cancellation dispute or guarantee fund claim) on an order immediately pauses the 24h auto-release timer
- Escrow remains frozen for the full duration of the dispute review
- On dispute resolution by ops: escrow released per ops decision (to courier, to SME, or refunded)
- Both parties notified of escrow outcome via FCM

---

## EPIC 8 — Trust & IC System

### US-8.1 — IC Score Display
> As any user, I want to see a counterpart's IC score and badge so that I can make trust-informed decisions.

**Acceptance Criteria:**
- Displayed on: courier applicant cards (for SMEs), SME order cards (for couriers)
- Before 10 completed orders: "Welcome Aboard" badge shown
- After 10 completed orders: IC percentage + badge tier (Trusted / standard / Warning)
- IC formula: `IC = (Delivered / (Delivered + Cancelled)) × 100`

---

### US-8.2 — IC Threshold Warnings & Badge Suspension
> As a platform user, I want to be notified when my IC drops into warning or suspension territory so that I can take action to recover.

**Acceptance Criteria:**
- 60–69%: warning banner on profile + FCM notification: *"Trust is key for Movena and all collaborators"*
- <60%: Trusted badge suspended + FCM notification explaining benefits loss
- Benefits restored automatically when IC recovers above threshold — no manual action required

---

### US-8.3 — Trusted Badge Unlock
> As a user with ≥10 completed orders and IC ≥80%, I want my Trusted badge to unlock automatically so that I receive the associated benefits.

**Acceptance Criteria:**
- System evaluates badge eligibility after every order completion
- Courier benefit: Hoja de Criminalidad annual renewal becomes optional
- SME benefit: order publishing cap lifted (10 → unlimited)
- FCM push notification sent on badge unlock

---

## EPIC 9 — Notifications (FCM)

### US-9.1 — Core Notification Events
> As a platform user, I want to receive push notifications for key lifecycle events so that I stay informed without constantly checking the app.

| Event | Recipient | Channel |
|-------|-----------|---------|
| New applicant for my order | SME | FCM web push |
| Selected for delivery | Courier | FCM mobile push |
| Application not selected | Courier | FCM mobile push |
| Courier confirmed pickup | SME | FCM web push |
| Courier marked delivered | SME | FCM web push |
| 24h confirmation window reminder (T+20h) | SME | FCM web push |
| Escrow released (by SME or auto) | Courier + SME | FCM both |
| Escrow frozen — dispute opened | Courier + SME | FCM both |
| Dispute resolved by ops | Courier + SME | FCM both |
| Order cancelled by counterpart | Courier / SME | FCM both |
| New in-app chat message | Courier / SME | FCM both |
| Verification approved / rejected | Courier / SME | FCM both |
| IC warning triggered | Courier / SME | FCM both |
| IC badge suspended | Courier / SME | FCM both |
| Trusted badge unlocked | Courier / SME | FCM both |
| Guarantee fund claim outcome | SME | FCM web push |

---

## EPIC 10 — Admin / Operations Panel

> **Note:** This panel is managed internally by Lucian. Stories below define the minimum required capabilities for MVP operations.

### US-10.1 — Review Courier Identity Documents
> As a Movena Ops member, I want to review submitted courier documents and approve or reject them so that only verified individuals can accept orders.

**Acceptance Criteria:**
- Queue of pending document reviews with submission timestamp
- View cédula + hoja de criminalidad images
- Approve → account activated; courier notified via FCM
- Reject → rejection reason required; courier notified; attempt count decremented
- 48h SLA target visible per submission

---

### US-10.2 — Review SME Identity Documents
> As a Movena Ops member, I want to review SME cédula submissions and approve or reject them so that only verified businesses can publish orders.

**Acceptance Criteria:**
- Same review flow as courier document review
- Approval → SME state → "Verified"; can publish up to 10 orders
- 48h SLA target visible per submission

---

### US-10.3 — Review Disputed Cancellations
> As a Movena Ops member, I want to review cancellation disputes so that I can decide whether to waive IC impact for justified cancellations.

**Acceptance Criteria:**
- Queue of flagged disputed cancellations
- View: order detail, cancellation reason submitted by user, in-app chat history, delivery photo if available
- Decision: Waive IC impact OR Uphold IC impact
- Escrow released per decision if frozen
- Both parties notified of decision via FCM

---

### US-10.4 — Review Guarantee Fund Claims
> As a Movena Ops member, I want to review SME guarantee fund claims so that I can approve or reject compensation from the fund.

**Acceptance Criteria:**
- Queue of open claims with order detail, SME-provided evidence, in-app chat history
- Approve → compensation issued to SME (up to declared order value, max CRC equivalent of $100); courier account flagged; escrow released
- Reject → SME notified with reason; escrow released to courier
- Both parties notified of outcome via FCM

---

## EPIC 11 — In-App Communication

### US-11.1 — Send Messages in Order Chat
> As a Courier or SME with a mutually accepted order, I want to send messages through an in-app chat so that I can coordinate without the platform exposing my personal contact information.

**Acceptance Criteria:**
- Chat available from the moment of mutual acceptance (courier selected by SME)
- Messages delivered in real-time (or near real-time)
- The platform never displays or shares phone numbers with counterparties
- Users may voluntarily share personal contact information through chat at their own discretion
- FCM push notification sent to recipient on each new message
- Chat accessible from the active order screen on both Flutter app and React dashboard

---

### US-11.2 — View Chat History
> As a Courier, SME, or Movena Ops member, I want to view the full message history for an order so that it can be used for coordination and dispute evidence.

**Acceptance Criteria:**
- Full chat history accessible within the order detail screen for both parties
- History retained after order completion (not deleted on close)
- History accessible to Movena Ops reviewers when reviewing disputes — read-only
- No message editing or deletion by users (immutable record for dispute integrity)

---

## Story Count Summary

| Epic | Stories |
|------|---------|
| E1 — Courier Onboarding | 4 |
| E2 — Courier Mobility Events | 2 |
| E3 — SME Onboarding | 4 |
| E4 — Order Management (SME) | 5 |
| E5 — Order Discovery & Application | 4 |
| E6 — Delivery Execution | 4 |
| E7 — Payment & Escrow | 5 |
| E8 — Trust & IC System | 3 |
| E9 — Notifications | 1 (consolidated event table) |
| E10 — Admin / Operations | 4 |
| E11 — In-App Communication | 2 |
| **Total** | **38 stories** |

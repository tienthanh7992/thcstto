--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-29 00:45:45 +07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16494)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id bigserial NOT NULL,
    index integer,
    index_str character varying(100),
    content text,
    max_point double precision,
    is_increase boolean,
    question_role character varying(100),
    role_id bigint NOT NULL,
    start_point double precision DEFAULT 1,
    "group" text
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16492)
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_seq OWNER TO postgres;

--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 204
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- TOC entry 3011 (class 2604 OID 16497)
-- Name: question id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- TOC entry 3138 (class 0 OID 16494)
-- Dependencies: 205
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (1, 2, '1', 'Chấp hành tốt đường lối, chủ trương của Đảng, chính sách pháp luật của nhà nước.', 5, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (2, 1, 'I', 'Ý THỨC TỔ CHỨC KỶ LUẬT', 20, true, 'TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (3, 4, '1.2', 'Có phẩm chất đạo đức tốt, có tinh thần nêu gương, tận tụy, trung thực trong công việc, sẵn sàng nhận nhiệm vụ. Có thái độ phục vụ nhân dân đúng mực; không hách dịch, cửa quyền, phiền hà, tiêu cực trong thực hiện công vụ.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (4, 3, '1.1', 'Gương mẫu chấp hành tốt đường lối, chủ trương của Đảng, chính sách pháp luật của nhà nước', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (5, 11, '2.5', 'Thực hiện ngày giờ công theo qui định', 8, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (6, 6, '2', 'Chấp hành nghiêm giờ làm việc, nội quy, quy chế, quy định của cơ quan, đơn vị gồm:', 15, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (7, 5, '1.3', 'Có tinh thần đoàn kết, thực hiện nguyên tắc tập trung dân chủ trong đơn vị', 1, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (8, 8, '2.2', 'Chấp hành kỷ luật, kỷ cương hành chính và các văn bản của Huyện ủy - UBND Huyện áp dụng đối với CBCCVC, LĐHĐ huyện, xã;
Sử dụng hiệu quả thời gian làm việc. Chấp hành quy định ra, vào cơ quan; quản lý bảo vệ tài sản, trang thiết bị của cơ quan. Đeo thẻ chức danh trong giờ làm việc. Sắp xếp, bài trí chỗ làm việc gọn gàng, ngăn nắp, sạch sẽ.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (9, 7, '2.1', 'Thực hiện tốt văn hoá công sở; giao tiếp thân thiện, lịch sự, ngôn ngữ chuẩn mực, rõ ràng. Mặc trang phục lịch sự, phù hợp với hoàn cảnh, tính chất công việc, đúng quy định của cơ quan.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (10, 10, '2.4', 'Giữ gìn bí mật nhà nước trong cơ quan, đơn vị và thực hiện nghiêm kỷ luật phát ngôn.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (11, 9, '2.3', 'Xây dựng hình ảnh, giữ gìn uy tín cho bản thân, cơ quan, đơn vị và đồng nghiệp.', 1, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (13, 14, '1', 'Năng lực và kỹ năng lãnh đạo, điều hành', 20, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (14, 13, 'II', 'KẾT QUẢ THỰC HIỆN NHIỆM VỤ', 70, true, 'TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (23, 25, '2', 'Thực hiện nhiệm vụ theo kế hoạch, lịch công tác đảm bảo tiến độ, chất lượng
(theo tiêu chí thi đua)', 50, true, 'SUB_TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (31, 31, 'III', 'ĐIỂM THƯỞNG 
(theo tiêu chí thi đua)', 10, true, 'TOPIC', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (35, 35, NULL, 'Tổng điểm', 100, true, 'TOTAL', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (16, 15, '1.1', 'Chủ động nghiên cứu, cập nhật kịp thời các kiến thức pháp luật, các kiến thức, kỹ năng về chuyên môn nghiệp vụ; tham mưu cho Hiệu trưởng các giải pháp nâng cao chất lượng dạy và học đáp ứng với yêu cầu đổi mới đạt hiệu quả, chất lượng.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (18, 20, '1.6', 'Có năng lực tập hợp GV, NV xây dựng nhà trường đoàn kết, thống nhất.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (19, 19, '1.5', 'Thường xuyên kiểm tra việc thực hiện chuyên môn của GV, NV đảm bảo quy định. Có khả năng bao quát, đôn đốc việc thực hiện nhiệm vụ của GV, NV; giải quyết kịp thời những khó khăn, vướng mắc theo thẩm quyền được giao', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (20, 21, '1.7', 'Phối hợp với GV, NV thiết lập mối quan hệ tốt với phụ huynh học sinh, các tổ chức, cá nhân, đoàn thể có liên quan đến trong thực hiện nhiệm vụ', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (21, 22, '1.9', 'Sử dụng thành thạo ứng dụng CNTT đáp ứng yêu cầu quản lý, điều hành, giải quyết công việc', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (22, 18, '1.4', 'Tham mưu phân công nhiệm vụ cho giáo viên, nhân viên thuộc bộ phận phụ trách đảm bảo rõ người, rõ nội dung, tiến độ thực hiện.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (24, 23, '1.10', 'Tham mưu tổ chức, chủ trì, điều hành cuộc họp hiệu quả.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (26, 26, '2.1', 'Hoàn thành từ 90%-100% công việc theo kế hoạch, lịch công tác đảm bảo tiến độ và chất lượng', 50, true, 'QUESTION', 3, 0, '3-1');
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (15, 16, '1.2', 'Tham mưu có hiệu quả trong việc xây dựng các kế hoạch công tác, lịch công tác của cá nhân, bộ phận phụ trách đảm bảo tiến độ', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (17, 17, '1.3', 'Kiểm soát việc thực hiện của các tổ chuyên môn thuộc lĩnh vực được phân công phụ trách đảm bảo kịp thời, không bỏ sót công việc. Giải quyết công việc đúng quy trình quy định.', 2, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (32, 32, '1', 'Tham mưu, đề xuất giải pháp, mô hình mới đảm bảo chất lượng và tiến độ, được cấp có thẩm quyền phê duyệt', 4, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (33, 33, '2', 'Tham mưu có hiệu quả đối với các nhiệm vụ mới, khó, phức tạp theo phân công được lãnh đạo cơ quan, đơn vị ghi nhận', 3, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (34, 34, '3', 'Chủ động, sáng tạo, khoa học, cải tiến phương pháp làm việc, nâng cao hiệu quả công việc, có thành tích nổi bật', 3, true, 'QUESTION', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (12, 12, NULL, 'Nội dung bị trừ điểm:
+ Có phản ảnh, kiến nghị của phụ huynh học sinh, của nhân dân và đồng nghiệp về thái độ giao tiếp, ứng xử thiếu lịch sự với đồng nghiệp hoặc với học sinh (và xác minh sự việc là đúng);
+ Mặc trang phục không phù hợp môi trường sư phạm.
+ Thực hiện ngày giờ công không theo theo qui định.
+ Tuyên truyền các thông tin thiếu chính xác trên mạng xã hội hoặc có hành vi (lời nói, việc làm) gây ảnh hưởng tới uy tín của địa phương, ngành, nhà trường và đồng nghiệp;
+ Có hành vi (lời nói, việc làm, phát ngôn) gây ảnh hưởng tới uy tín của bản thân, đồng nghiệp, nhà trường.', 20, false, 'DECREASE', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (30, 30, NULL, 'Nội dung bị trừ điểm: 
- Không thực hiện nhiệm vụ theo đúng lịch công tác mà không có lý do...
- Không hoàn thành công việc đúng tiến độ và chất lượng công việc không theo đúng yêu cầu của nhà trường. 
- Không kịp thời xử lý, giải quyết dứt điểm các khiếu nại, kiến nghị của phụ huynh học sinh làm ảnh hưởng đến uy tín của nhà trường.
- Không báo cáo kịp thời với BGH các khó khăn, vướng mắc làm ảnh hưởng đến kết quả giải quyết công việc, đến uy tín của nhà trường....', 50, false, 'DECREASE', 3, 0, NULL);
INSERT INTO public.question (id, index, index_str, content, max_point, is_increase, question_role, role_id, start_point, "group") VALUES (25, 24, NULL, 'Nội dung bị trừ điểm:
+ Chưa kịp thời cập nhật kiến thức chuyên môn, phương pháp đổi mới trong thực hiện nhiệm vụ;
+ Xây dựng lịch công tác tuần, lịch báo giảng chưa khớp với sổ ghi đầu bài hoặc chưa hợp lý về nội dung hoặc còn bỏ sót nhiệm vụ;
+ Còn công việc bị bỏ sót hoặc bỏ chương trình giảng dạy chưa thực hiện;   
+ Lên lớp không có giáo án, soạn bải không theo phân phối chương trình, các loại hồ sơ, sổ sách nội dung không đảm bảo.
+ Giải quyết công việc không đúng quy trình.
+ Không báo cáo BGH kịp thời các nội dung còn vướng mắc xảy ra, không xử lý kịp thời, dứt điểm tình trạng học sinh mâu thuẫn, mất đoàn kết dẫn đến xích mích;
+ Chưa chủ động đề xuất giải pháp thực hiện nhiệm vụ được giao hoặc không báo cáo lãnh đạo kịp thời những khó khăn, vướng mắc làm ảnh hưởng tới kết quả, chất lượng công việc
+ Hàng tháng chậm đánh giá kết quả thực hiện nhiệm vụ theo quy định
+ Phối hợp với phụ huynh học sinh, đồng nghiệp và các tổ chức liên quan trong giải quyết công việc không hiệu quả, tạo căng thẳng, bức xúc
+ Chưa sử dụng thành thạo CNTT hoặc chưa ứng dụng CNTT trong đổi mới PPDH.  
+ Báo cáo số liệu, tài liệu bị sai sót về nội dung, hình thức.', 10, false, 'DECREASE', 3, 0, NULL);


--
-- TOC entry 3145 (class 0 OID 0)
-- Dependencies: 204
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_seq', 1, false);


--
-- TOC entry 3014 (class 2606 OID 16503)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- TOC entry 3015 (class 2606 OID 16504)
-- Name: question question_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(id);


-- Completed on 2018-10-29 00:45:45 +07

--
-- PostgreSQL database dump complete
--


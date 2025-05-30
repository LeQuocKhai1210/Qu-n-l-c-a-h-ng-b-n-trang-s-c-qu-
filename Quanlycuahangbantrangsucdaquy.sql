PGDMP         %                }            DT_QLCHBTSDQ    14.17    14.17 G    M           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            N           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            O           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            P           1262    17748    DT_QLCHBTSDQ    DATABASE     ]   CREATE DATABASE "DT_QLCHBTSDQ" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en-US';
    DROP DATABASE "DT_QLCHBTSDQ";
                postgres    false            �            1259    17832    chitietdonhang    TABLE     F  CREATE TABLE public.chitietdonhang (
    machitiet integer NOT NULL,
    madonhang integer NOT NULL,
    masanpham integer NOT NULL,
    soluong integer NOT NULL,
    gia numeric(10,2),
    CONSTRAINT chitietdonhang_gia_check CHECK ((gia >= (0)::numeric)),
    CONSTRAINT chitietdonhang_soluong_check CHECK ((soluong > 0))
);
 "   DROP TABLE public.chitietdonhang;
       public         heap    postgres    false            �            1259    17831    chitietdonhang_machitiet_seq    SEQUENCE     �   CREATE SEQUENCE public.chitietdonhang_machitiet_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.chitietdonhang_machitiet_seq;
       public          postgres    false    222            Q           0    0    chitietdonhang_machitiet_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.chitietdonhang_machitiet_seq OWNED BY public.chitietdonhang.machitiet;
          public          postgres    false    221            �            1259    17817    donhang    TABLE     �  CREATE TABLE public.donhang (
    madonhang integer NOT NULL,
    makhachhang integer NOT NULL,
    ngaydat timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    trangthai character varying(20) NOT NULL,
    tongtien numeric(10,2),
    CONSTRAINT donhang_tongtien_check CHECK ((tongtien >= (0)::numeric)),
    CONSTRAINT donhang_trangthai_check CHECK (((trangthai)::text = ANY ((ARRAY['ChoXuLy'::character varying, 'HoanThanh'::character varying, 'Huy'::character varying])::text[])))
);
    DROP TABLE public.donhang;
       public         heap    postgres    false            �            1259    17816    donhang_madonhang_seq    SEQUENCE     �   CREATE SEQUENCE public.donhang_madonhang_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.donhang_madonhang_seq;
       public          postgres    false    220            R           0    0    donhang_madonhang_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.donhang_madonhang_seq OWNED BY public.donhang.madonhang;
          public          postgres    false    219            �            1259    17851    hoadon    TABLE     Y  CREATE TABLE public.hoadon (
    mahoadon integer NOT NULL,
    madonhang integer NOT NULL,
    ngaythanhtoan timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    phuongthucthanhtoan character varying(50) NOT NULL,
    sotienthanhtoan numeric(10,2),
    CONSTRAINT hoadon_sotienthanhtoan_check CHECK ((sotienthanhtoan >= (0)::numeric))
);
    DROP TABLE public.hoadon;
       public         heap    postgres    false            �            1259    17850    hoadon_mahoadon_seq    SEQUENCE     �   CREATE SEQUENCE public.hoadon_mahoadon_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.hoadon_mahoadon_seq;
       public          postgres    false    224            S           0    0    hoadon_mahoadon_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.hoadon_mahoadon_seq OWNED BY public.hoadon.mahoadon;
          public          postgres    false    223            �            1259    17776 	   khachhang    TABLE     �   CREATE TABLE public.khachhang (
    makhachhang integer NOT NULL,
    hoten character varying(100) NOT NULL,
    sodienthoai character varying(15),
    diachi text,
    mataikhoan integer NOT NULL
);
    DROP TABLE public.khachhang;
       public         heap    postgres    false            �            1259    17775    khachhang_makhachhang_seq    SEQUENCE     �   CREATE SEQUENCE public.khachhang_makhachhang_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.khachhang_makhachhang_seq;
       public          postgres    false    214            T           0    0    khachhang_makhachhang_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.khachhang_makhachhang_seq OWNED BY public.khachhang.makhachhang;
          public          postgres    false    213            �            1259    17792    loaisanpham    TABLE     n   CREATE TABLE public.loaisanpham (
    maloai integer NOT NULL,
    tenloai character varying(100) NOT NULL
);
    DROP TABLE public.loaisanpham;
       public         heap    postgres    false            �            1259    17791    loaisanpham_maloai_seq    SEQUENCE     �   CREATE SEQUENCE public.loaisanpham_maloai_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.loaisanpham_maloai_seq;
       public          postgres    false    216            U           0    0    loaisanpham_maloai_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.loaisanpham_maloai_seq OWNED BY public.loaisanpham.maloai;
          public          postgres    false    215            �            1259    17760    nhanvien    TABLE     �   CREATE TABLE public.nhanvien (
    manhanvien integer NOT NULL,
    hoten character varying(100) NOT NULL,
    sodienthoai character varying(15),
    diachi text,
    mataikhoan integer NOT NULL
);
    DROP TABLE public.nhanvien;
       public         heap    postgres    false            �            1259    17759    nhanvien_manhanvien_seq    SEQUENCE     �   CREATE SEQUENCE public.nhanvien_manhanvien_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.nhanvien_manhanvien_seq;
       public          postgres    false    212            V           0    0    nhanvien_manhanvien_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.nhanvien_manhanvien_seq OWNED BY public.nhanvien.manhanvien;
          public          postgres    false    211            �            1259    17801    sanpham    TABLE     �  CREATE TABLE public.sanpham (
    masanpham integer NOT NULL,
    tensanpham character varying(100) NOT NULL,
    maloai integer NOT NULL,
    mota text,
    chatlieu character varying(50),
    daquy character varying(50),
    gia numeric(10,2) NOT NULL,
    soluongton integer NOT NULL,
    hinhanh character varying(255),
    CONSTRAINT sanpham_gia_check CHECK ((gia >= (0)::numeric)),
    CONSTRAINT sanpham_soluongton_check CHECK ((soluongton >= 0))
);
    DROP TABLE public.sanpham;
       public         heap    postgres    false            �            1259    17800    sanpham_masanpham_seq    SEQUENCE     �   CREATE SEQUENCE public.sanpham_masanpham_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.sanpham_masanpham_seq;
       public          postgres    false    218            W           0    0    sanpham_masanpham_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.sanpham_masanpham_seq OWNED BY public.sanpham.masanpham;
          public          postgres    false    217            �            1259    17750    taikhoan    TABLE     �  CREATE TABLE public.taikhoan (
    mataikhoan integer NOT NULL,
    tendangnhap character varying(100) NOT NULL,
    matkhau character varying(100) NOT NULL,
    vaitro character varying(100) NOT NULL,
    CONSTRAINT taikhoan_vaitro_check CHECK (((vaitro)::text = ANY (ARRAY[('admin'::character varying)::text, ('nhanvien'::character varying)::text, ('khachhang'::character varying)::text])))
);
    DROP TABLE public.taikhoan;
       public         heap    postgres    false            �            1259    17749    taikhoan_mataikhoan_seq    SEQUENCE     �   CREATE SEQUENCE public.taikhoan_mataikhoan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.taikhoan_mataikhoan_seq;
       public          postgres    false    210            X           0    0    taikhoan_mataikhoan_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.taikhoan_mataikhoan_seq OWNED BY public.taikhoan.mataikhoan;
          public          postgres    false    209            �           2604    17835    chitietdonhang machitiet    DEFAULT     �   ALTER TABLE ONLY public.chitietdonhang ALTER COLUMN machitiet SET DEFAULT nextval('public.chitietdonhang_machitiet_seq'::regclass);
 G   ALTER TABLE public.chitietdonhang ALTER COLUMN machitiet DROP DEFAULT;
       public          postgres    false    221    222    222            �           2604    17820    donhang madonhang    DEFAULT     v   ALTER TABLE ONLY public.donhang ALTER COLUMN madonhang SET DEFAULT nextval('public.donhang_madonhang_seq'::regclass);
 @   ALTER TABLE public.donhang ALTER COLUMN madonhang DROP DEFAULT;
       public          postgres    false    219    220    220            �           2604    17854    hoadon mahoadon    DEFAULT     r   ALTER TABLE ONLY public.hoadon ALTER COLUMN mahoadon SET DEFAULT nextval('public.hoadon_mahoadon_seq'::regclass);
 >   ALTER TABLE public.hoadon ALTER COLUMN mahoadon DROP DEFAULT;
       public          postgres    false    223    224    224            �           2604    17779    khachhang makhachhang    DEFAULT     ~   ALTER TABLE ONLY public.khachhang ALTER COLUMN makhachhang SET DEFAULT nextval('public.khachhang_makhachhang_seq'::regclass);
 D   ALTER TABLE public.khachhang ALTER COLUMN makhachhang DROP DEFAULT;
       public          postgres    false    213    214    214            �           2604    17795    loaisanpham maloai    DEFAULT     x   ALTER TABLE ONLY public.loaisanpham ALTER COLUMN maloai SET DEFAULT nextval('public.loaisanpham_maloai_seq'::regclass);
 A   ALTER TABLE public.loaisanpham ALTER COLUMN maloai DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    17763    nhanvien manhanvien    DEFAULT     z   ALTER TABLE ONLY public.nhanvien ALTER COLUMN manhanvien SET DEFAULT nextval('public.nhanvien_manhanvien_seq'::regclass);
 B   ALTER TABLE public.nhanvien ALTER COLUMN manhanvien DROP DEFAULT;
       public          postgres    false    212    211    212            �           2604    17804    sanpham masanpham    DEFAULT     v   ALTER TABLE ONLY public.sanpham ALTER COLUMN masanpham SET DEFAULT nextval('public.sanpham_masanpham_seq'::regclass);
 @   ALTER TABLE public.sanpham ALTER COLUMN masanpham DROP DEFAULT;
       public          postgres    false    217    218    218                       2604    17753    taikhoan mataikhoan    DEFAULT     z   ALTER TABLE ONLY public.taikhoan ALTER COLUMN mataikhoan SET DEFAULT nextval('public.taikhoan_mataikhoan_seq'::regclass);
 B   ALTER TABLE public.taikhoan ALTER COLUMN mataikhoan DROP DEFAULT;
       public          postgres    false    210    209    210            H          0    17832    chitietdonhang 
   TABLE DATA           W   COPY public.chitietdonhang (machitiet, madonhang, masanpham, soluong, gia) FROM stdin;
    public          postgres    false    222   sX       F          0    17817    donhang 
   TABLE DATA           W   COPY public.donhang (madonhang, makhachhang, ngaydat, trangthai, tongtien) FROM stdin;
    public          postgres    false    220   �X       J          0    17851    hoadon 
   TABLE DATA           j   COPY public.hoadon (mahoadon, madonhang, ngaythanhtoan, phuongthucthanhtoan, sotienthanhtoan) FROM stdin;
    public          postgres    false    224   Y       @          0    17776 	   khachhang 
   TABLE DATA           X   COPY public.khachhang (makhachhang, hoten, sodienthoai, diachi, mataikhoan) FROM stdin;
    public          postgres    false    214   �Y       B          0    17792    loaisanpham 
   TABLE DATA           6   COPY public.loaisanpham (maloai, tenloai) FROM stdin;
    public          postgres    false    216   �Z       >          0    17760    nhanvien 
   TABLE DATA           V   COPY public.nhanvien (manhanvien, hoten, sodienthoai, diachi, mataikhoan) FROM stdin;
    public          postgres    false    212   �Z       D          0    17801    sanpham 
   TABLE DATA           q   COPY public.sanpham (masanpham, tensanpham, maloai, mota, chatlieu, daquy, gia, soluongton, hinhanh) FROM stdin;
    public          postgres    false    218   �[       <          0    17750    taikhoan 
   TABLE DATA           L   COPY public.taikhoan (mataikhoan, tendangnhap, matkhau, vaitro) FROM stdin;
    public          postgres    false    210   �\       Y           0    0    chitietdonhang_machitiet_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.chitietdonhang_machitiet_seq', 5, true);
          public          postgres    false    221            Z           0    0    donhang_madonhang_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.donhang_madonhang_seq', 5, true);
          public          postgres    false    219            [           0    0    hoadon_mahoadon_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hoadon_mahoadon_seq', 3, true);
          public          postgres    false    223            \           0    0    khachhang_makhachhang_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.khachhang_makhachhang_seq', 14, true);
          public          postgres    false    213            ]           0    0    loaisanpham_maloai_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.loaisanpham_maloai_seq', 5, true);
          public          postgres    false    215            ^           0    0    nhanvien_manhanvien_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.nhanvien_manhanvien_seq', 11, true);
          public          postgres    false    211            _           0    0    sanpham_masanpham_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.sanpham_masanpham_seq', 40, true);
          public          postgres    false    217            `           0    0    taikhoan_mataikhoan_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.taikhoan_mataikhoan_seq', 50, true);
          public          postgres    false    209            �           2606    17839 "   chitietdonhang chitietdonhang_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.chitietdonhang
    ADD CONSTRAINT chitietdonhang_pkey PRIMARY KEY (machitiet);
 L   ALTER TABLE ONLY public.chitietdonhang DROP CONSTRAINT chitietdonhang_pkey;
       public            postgres    false    222            �           2606    17825    donhang donhang_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.donhang
    ADD CONSTRAINT donhang_pkey PRIMARY KEY (madonhang);
 >   ALTER TABLE ONLY public.donhang DROP CONSTRAINT donhang_pkey;
       public            postgres    false    220            �           2606    17858    hoadon hoadon_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.hoadon
    ADD CONSTRAINT hoadon_pkey PRIMARY KEY (mahoadon);
 <   ALTER TABLE ONLY public.hoadon DROP CONSTRAINT hoadon_pkey;
       public            postgres    false    224            �           2606    17785 "   khachhang khachhang_mataikhoan_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.khachhang
    ADD CONSTRAINT khachhang_mataikhoan_key UNIQUE (mataikhoan);
 L   ALTER TABLE ONLY public.khachhang DROP CONSTRAINT khachhang_mataikhoan_key;
       public            postgres    false    214            �           2606    17783    khachhang khachhang_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.khachhang
    ADD CONSTRAINT khachhang_pkey PRIMARY KEY (makhachhang);
 B   ALTER TABLE ONLY public.khachhang DROP CONSTRAINT khachhang_pkey;
       public            postgres    false    214            �           2606    17797    loaisanpham loaisanpham_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.loaisanpham
    ADD CONSTRAINT loaisanpham_pkey PRIMARY KEY (maloai);
 F   ALTER TABLE ONLY public.loaisanpham DROP CONSTRAINT loaisanpham_pkey;
       public            postgres    false    216            �           2606    17799 #   loaisanpham loaisanpham_tenloai_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.loaisanpham
    ADD CONSTRAINT loaisanpham_tenloai_key UNIQUE (tenloai);
 M   ALTER TABLE ONLY public.loaisanpham DROP CONSTRAINT loaisanpham_tenloai_key;
       public            postgres    false    216            �           2606    17769     nhanvien nhanvien_mataikhoan_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.nhanvien
    ADD CONSTRAINT nhanvien_mataikhoan_key UNIQUE (mataikhoan);
 J   ALTER TABLE ONLY public.nhanvien DROP CONSTRAINT nhanvien_mataikhoan_key;
       public            postgres    false    212            �           2606    17767    nhanvien nhanvien_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.nhanvien
    ADD CONSTRAINT nhanvien_pkey PRIMARY KEY (manhanvien);
 @   ALTER TABLE ONLY public.nhanvien DROP CONSTRAINT nhanvien_pkey;
       public            postgres    false    212            �           2606    17810    sanpham sanpham_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.sanpham
    ADD CONSTRAINT sanpham_pkey PRIMARY KEY (masanpham);
 >   ALTER TABLE ONLY public.sanpham DROP CONSTRAINT sanpham_pkey;
       public            postgres    false    218            �           2606    17756    taikhoan taikhoan_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.taikhoan
    ADD CONSTRAINT taikhoan_pkey PRIMARY KEY (mataikhoan);
 @   ALTER TABLE ONLY public.taikhoan DROP CONSTRAINT taikhoan_pkey;
       public            postgres    false    210            �           2606    17758 !   taikhoan taikhoan_tendangnhap_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.taikhoan
    ADD CONSTRAINT taikhoan_tendangnhap_key UNIQUE (tendangnhap);
 K   ALTER TABLE ONLY public.taikhoan DROP CONSTRAINT taikhoan_tendangnhap_key;
       public            postgres    false    210            �           2606    17840 ,   chitietdonhang chitietdonhang_madonhang_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.chitietdonhang
    ADD CONSTRAINT chitietdonhang_madonhang_fkey FOREIGN KEY (madonhang) REFERENCES public.donhang(madonhang) ON DELETE CASCADE;
 V   ALTER TABLE ONLY public.chitietdonhang DROP CONSTRAINT chitietdonhang_madonhang_fkey;
       public          postgres    false    3236    222    220            �           2606    17845 ,   chitietdonhang chitietdonhang_masanpham_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.chitietdonhang
    ADD CONSTRAINT chitietdonhang_masanpham_fkey FOREIGN KEY (masanpham) REFERENCES public.sanpham(masanpham) ON DELETE CASCADE;
 V   ALTER TABLE ONLY public.chitietdonhang DROP CONSTRAINT chitietdonhang_masanpham_fkey;
       public          postgres    false    3234    218    222            �           2606    17826     donhang donhang_makhachhang_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.donhang
    ADD CONSTRAINT donhang_makhachhang_fkey FOREIGN KEY (makhachhang) REFERENCES public.khachhang(makhachhang) ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.donhang DROP CONSTRAINT donhang_makhachhang_fkey;
       public          postgres    false    220    3228    214            �           2606    17859    hoadon hoadon_madonhang_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.hoadon
    ADD CONSTRAINT hoadon_madonhang_fkey FOREIGN KEY (madonhang) REFERENCES public.donhang(madonhang) ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.hoadon DROP CONSTRAINT hoadon_madonhang_fkey;
       public          postgres    false    3236    220    224            �           2606    17786 #   khachhang khachhang_mataikhoan_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.khachhang
    ADD CONSTRAINT khachhang_mataikhoan_fkey FOREIGN KEY (mataikhoan) REFERENCES public.taikhoan(mataikhoan) ON DELETE CASCADE;
 M   ALTER TABLE ONLY public.khachhang DROP CONSTRAINT khachhang_mataikhoan_fkey;
       public          postgres    false    210    214    3218            �           2606    17770 !   nhanvien nhanvien_mataikhoan_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.nhanvien
    ADD CONSTRAINT nhanvien_mataikhoan_fkey FOREIGN KEY (mataikhoan) REFERENCES public.taikhoan(mataikhoan) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.nhanvien DROP CONSTRAINT nhanvien_mataikhoan_fkey;
       public          postgres    false    210    3218    212            �           2606    17811    sanpham sanpham_maloai_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sanpham
    ADD CONSTRAINT sanpham_maloai_fkey FOREIGN KEY (maloai) REFERENCES public.loaisanpham(maloai) ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.sanpham DROP CONSTRAINT sanpham_maloai_fkey;
       public          postgres    false    218    216    3230            H   *   x�3�4�@S0�30�2�ACNsS��1'rZ"�b���� -.	r      F   `   x�]�!� FἜ������H����F�d������o�@�!:�e���K�ji�X��#$C�嘣>z�}?׋�~4P4YLY~�i��cn���      J   Z   x�3�4�4202�50�50T04�20 "N��ʇ����3��Z��ihj z\F��M�
�PM!�w7�)�>ܵ�����>F��� �M�      @   �   x�M��J1���S��&��l�6w'+,ba��f��r��"b#��^!�`w)s�y�"���}�7�M<�9�m�OX����9��LH�OLR�Y;��	�n��j�u5/���xq�wX���l�9B�e��i�%��ӵI�I�����0���}x�DR*�5�/���:gqa��>-)�	&���JXeð�:�:Ȕ6����5.���dG����s�/�M�0܀`Ws��+�b�      B   I   x�3���x�ku����E�
���w7�qs:ޒ��P���e�vx�]�e���p��d��Ë�b���� ���      >   �   x�3��9�J!�����
�w-��4�40442615�8�X!��<���҇���8�:
!zΉ�
>��e yww�e(��p��t���8��8��K+�n�N*�8���¼tt<oJTp�#�X#.Cts�9L�,@�q� �Pp�8�V�73/�Ӕ+F��� �X�      D   I  x�]��N�0���S�TQ��v��U*&�Tv�q�� yD�����va` !�d`H���pI���}��;�Ci���(ƣ��z����m!���S��o���OJ�E��4Wb��:��\�dʵ�����\j�2Ӧ�W8d�q����Ri�׈Hă��{^�$�$��ӕxҰ|�?UT�Y6���h��RI����f/@���3�`<S�\6��~׶G��%�PI�TΪw���;S=6��������y���A�pBBN_Q.�����	�<1yA�gJtP���z6��v�
h%�n�.L��E\ږe�Lx��      <   [   x�3�LL���30�442615�p��8�2��2S�d`"\Ɯ���0(��e�22�JcJ�C�L��h	�db1π3)S8F��� �E:�     
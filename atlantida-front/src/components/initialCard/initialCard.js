import styles from "./initialCard.module.css";

const InitialCard = () => {
    return (
        <div className={styles.card}>
            <div className={styles.leftSection}>
                <h1 className={styles.title}>
                    OS MELHORES PESCADOS DE SANTOS
                </h1>
                <div className={styles.button}>
                    <img src="/assets/images/shop_cart.svg" alt="carrinho"/>
                    Compre com a gente!
                </div>
            </div>

            <div className={styles.rightSection}>
                <img src="/assets/images/image_1.svg" alt="imagem de peixes e crustáceos"/>
            </div>
        </div>
    );
};

export default InitialCard;